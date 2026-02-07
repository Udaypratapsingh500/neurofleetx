package com.example.neurofleetx.service;

import com.example.neurofleetx.dto.LoginRequest;
import com.example.neurofleetx.dto.RegisterRequest;
import com.example.neurofleetx.model.User;
import com.example.neurofleetx.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User login(LoginRequest request) {
        return userRepository.findByEmail(request.getEmail())
                .filter(user ->
                        passwordEncoder.matches(
                                request.getPassword(),
                                user.getPassword()
                        )
                )
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));
    }

    public User register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        return userRepository.save(user);
    }
}