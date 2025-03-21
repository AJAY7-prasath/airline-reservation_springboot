package com.flightreservation.backend.controller;

import com.flightreservation.backend.model.User;
import com.flightreservation.backend.repository.UserRepository;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
//            if (new BCryptPasswordEncoder().matches(password, user.getPassword())) {
//                return ResponseEntity.ok(Map.of("role", user.getRole()));
//            }
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

}
