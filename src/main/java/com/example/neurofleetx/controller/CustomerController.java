package com.example.neurofleetx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @GetMapping("/customer/dashboard")
    public String dashboard() {
        return "Welcome CUSTOMER 🚀";
    }
}