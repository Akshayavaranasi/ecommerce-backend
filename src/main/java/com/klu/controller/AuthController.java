package com.klu.controller;

import com.klu.model.User;
import com.klu.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    private final UserService userService;

    // Constructor Injection
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Signup API
    @PostMapping("/signup")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    // Login API
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword());
    }
}
