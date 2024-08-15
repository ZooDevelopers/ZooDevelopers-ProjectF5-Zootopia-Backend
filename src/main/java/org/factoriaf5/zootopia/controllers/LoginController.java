package org.factoriaf5.zootopia.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @PostMapping("/login")
    public ResponseEntity<String> login() {
        SecurityContext contextHolder = SecurityContextHolder.getContext();
        Authentication auth = contextHolder.getAuthentication();

        if (auth != null && auth.isAuthenticated()) {
            return ResponseEntity.ok("Login success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        return ResponseEntity.ok("Logout success");
    }
}

