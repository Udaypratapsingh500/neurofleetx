package com.example.neurofleetx;

import com.example.neurofleetx.model.Role;
import com.example.neurofleetx.model.User;
import com.example.neurofleetx.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableScheduling   // ✅ ADDED for telemetry simulation
public class NeurofleetxAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(NeurofleetxAuthApplication.class, args);
    }

    // ✅ Existing user initialization (UNCHANGED)
    @Bean
    CommandLineRunner initUsers(UserRepository userRepository,
                                PasswordEncoder passwordEncoder) {
        return args -> {

            if (userRepository.findByEmail("customer1@gmail.com").isEmpty()) {

                User user = new User();
                user.setEmail("customer1@gmail.com");
                user.setPassword(passwordEncoder.encode("123456"));
                user.setRole(Role.CUSTOMER);

                userRepository.save(user);
                System.out.println("✅ Default user created");
            }
        };
    }
}