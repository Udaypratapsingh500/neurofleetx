package com.example.neurofleetx.controller;

import com.example.neurofleetx.dto.LoginRequest;
import com.example.neurofleetx.dto.RegisterRequest;
import com.example.neurofleetx.model.User;
import com.example.neurofleetx.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }
}