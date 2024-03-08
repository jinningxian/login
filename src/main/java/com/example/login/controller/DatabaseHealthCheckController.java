package com.example.login.controller;

import com.example.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseHealthCheckController {

    @Autowired
    private UserRepository userRepository; // Assuming you have a UserRepository

    @GetMapping("/health/database")
    public ResponseEntity<String> checkDatabaseHealth() {
        try {
            userRepository.findAll(); // Perform a simple database operation
            return ResponseEntity.ok("Database connection is healthy");
        } catch (Exception ex) {
            return ResponseEntity.status(500).body("Database connection failed: " + ex.getMessage());
        }
    }
}
