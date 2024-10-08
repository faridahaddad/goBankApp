package com._concept.Gobank.controller;

import com._concept.Gobank.model.CreditCardProduct;
import com._concept.Gobank.service.CreditCardProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CreditCardProductController {

    @Autowired
    private CreditCardProductService creditCardProductService;

    // Display all cards
    @GetMapping("/products")
    public String viewAllCards(Model model) {
        model.addAttribute("cards", creditCardProductService.getAllCreditCardProducts());
        return "products";  // Thymeleaf template
    }

    @GetMapping("/admin")
    public String viewAllCardsg(Model model) {
        model.addAttribute("cards", creditCardProductService.getAllCreditCardProducts());
        return "admin";  // Thymeleaf template
    }

    // Form to add a new card
    @GetMapping("/addCard")
    public String showAddCardForm(Model model) {
        model.addAttribute("creditCardProduct", new CreditCardProduct());
        return "addCard";  // Thymeleaf template for adding a new card
    }


    @PostMapping("/saveCard")
    public String saveCard(@RequestParam("file") MultipartFile file, @ModelAttribute CreditCardProduct card) {
        // Check if the card has an id, if it does, update the existing card
        if (card.getId() != null) {
            // Fetch the existing card from the database
            CreditCardProduct existingCard = creditCardProductService.getCreditCardProductById(card.getId());
            if (existingCard != null) {
                // Update the existing card's details with the new data from the form
                existingCard.setCreditName(card.getCreditName());
                existingCard.setBonus(card.getBonus());
                existingCard.setDescription(card.getDescription());
                // Handle file upload if needed
                creditCardProductService.saveCreditCardProduct(existingCard, file);
            }
        } else {
            // If the card has no ID, treat it as a new card
            creditCardProductService.saveCreditCardProduct(card, file);
        }

        return "redirect:/admin";
    }


    @GetMapping("/editCard/{id}")
    public String showEditCardForm(@PathVariable("id") Long id, Model model) {
        CreditCardProduct card = creditCardProductService.getCreditCardProductById(id);
        if (card != null) {
            model.addAttribute("creditCardProduct", card); // Add card to the model
            return "addCard"; // Reuse the same template
        }
        return "redirect:/admin"; // Redirect if card not found
    }

    // Delete card
    @GetMapping("/deleteCard/{id}")
    public String deleteCard(@PathVariable("id") Long id) {
        creditCardProductService.deleteCreditCardProduct(id);
        return "redirect:/admin";
    }
}
