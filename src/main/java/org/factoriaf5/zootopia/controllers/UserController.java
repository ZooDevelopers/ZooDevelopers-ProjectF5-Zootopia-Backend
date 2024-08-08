package org.factoriaf5.zootopia.controllers;


import java.util.List;

import org.factoriaf5.zootopia.models.User;
import org.factoriaf5.zootopia.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
// @CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class UserController {

    private UserService services;

    public UserController(UserService services) {
        this.services = services;
    }

    @GetMapping(path = "/api/v1/users")
    public List<User> index() {

        return services.getAll();

    }

}