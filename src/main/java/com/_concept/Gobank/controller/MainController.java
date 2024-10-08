package com._concept.Gobank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    //Show the page login admin form
    @GetMapping("/adminLogin")
    public String adminLogin() {
        return "adminLogin";
    }
}
   //
