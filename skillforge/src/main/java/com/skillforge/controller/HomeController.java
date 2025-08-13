package com.skillforge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String root() {
        return "redirect:/index.html";  // static landing page
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";  // loads login.html from templates
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";  // loads register.html from templates
    }

    @GetMapping("/get-started")
    public String getStarted() {
        return "redirect:/register";  // or to a welcome page
    }

    @GetMapping("/home")
    public String userHome() {
        return "home";  // after login
    }
}
