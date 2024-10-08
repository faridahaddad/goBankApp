package com._concept.Gobank.service;

import com._concept.Gobank.model.CreditCardProduct;
import com._concept.Gobank.repository.CreditCardProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class CreditCardProductService {

    @Autowired
    private CreditCardProductRepository creditCardProductRepository;

    // Define the directory to store the uploaded images
//    private final String uploadDir = "../";
    private final String currentDir = System.getProperty("user.dir");
//    private final String uploadDir = currentDir + "/uploads/";
    private final String uploadDir = currentDir + "/src/main/resources/static/upload/";


    // Fetch all credit card products
    public List<CreditCardProduct> getAllCreditCardProducts() {
        return creditCardProductRepository.findAll();
    }

    // Fetch by ID
    public CreditCardProduct getCreditCardProductById(Long id) {
        return creditCardProductRepository.findById(id).orElse(null);
    }

    // Delete card by ID
    public void deleteCreditCardProduct(Long id) {
        creditCardProductRepository.deleteById(id);
    }
    // Service class method with MultipartFile


    // Service class method with MultipartFile
    public void saveCreditCardProduct(CreditCardProduct card, MultipartFile file) {
        // Check if the file is not empty
        if (!file.isEmpty()) {
            try {
                // Get the original filename
                String fileName = file.getOriginalFilename();

                // Create the upload directory if it doesn't exist
                File uploadDirectory = new File(uploadDir);
                if (!uploadDirectory.exists()) {
                    uploadDirectory.mkdirs();  // Create the directory if it doesn't exist
                }

                // Save the file to the directory
                File savedFile = new File(uploadDirectory + File.separator + fileName);
                file.transferTo(savedFile);

                // Set the file path or URL in the card object (adjust the path based on your app)
                card.setImageUrl("/upload/" + fileName);
//                card.setImageUrl("/" + uploadDir + fileName);
            } catch (IOException e) {
                e.printStackTrace();
                // Handle the error, you could throw an exception or log the error as needed
            }
        }

        // Save the card to the database
        creditCardProductRepository.save(card);
    }

}
