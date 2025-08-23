package com.example.Skill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Skill.entity.User;
import com.example.Skill.repository.NotificationRepository;
import com.example.Skill.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/notifications")
public class NotificationController {
	private final NotificationRepository notifRepo;
	//private final UserRepository userRepo;
	public NotificationController(NotificationRepository notifRepo, UserRepository userRepo) {
		this.notifRepo = notifRepo;
		//this.userRepo = userRepo;
	}
	@GetMapping
	public String listForLoggedInUser(HttpSession session, Model model) {
	    User user = (User) session.getAttribute("loggedInUser");
	    if (user == null) return "redirect:/login";

	    model.addAttribute("notifications", notifRepo.findByUserIdOrderByCreatedAtDesc(user.getId()));
	    return "notifications";
	}	
	@PostMapping("/read/{id}")
	public String markRead(@PathVariable Long id, @RequestParam Long userId) {
		notifRepo.findById(id).ifPresent(n -> {
			n.setRead(true);
			notifRepo.save(n);
		});
		return "redirect:/notifications/user/" + userId;
	}
}
