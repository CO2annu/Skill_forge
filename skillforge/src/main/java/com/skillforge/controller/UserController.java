package com.skillforge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skillforge.entity.User;
import com.skillforge.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {  // Fixed spelling

    private final UserService userService;

    @PostMapping("/register")  // Corrected endpoint
    public String registerUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "home";  // Frontend should handle this
    }
}
