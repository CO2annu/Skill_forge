package com.example.Skill.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Skill.entity.User;
import com.example.Skill.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	private final UserRepository userRepo;

	public LoginController(UserRepository userRepo) {	
		this.userRepo = userRepo;
	}
	@GetMapping("/login")
	public String showLoginForm() {
		return "login";
	}
	
	@PostMapping("/login")
	public String processLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
		Optional<User> userOpt = userRepo.findByEmail(email);
		if (userOpt.isPresent() && userOpt.get().getPassword().equals(password)) {
		      session.setAttribute("loggedInUser", userOpt.get());
		      return "redirect:/home";
		} else {
		      model.addAttribute("error", "Invalid email or password");
		      return "login";
		}
	}
}
