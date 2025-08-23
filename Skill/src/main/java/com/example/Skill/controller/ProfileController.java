package com.example.Skill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Skill.entity.User;
import com.example.Skill.repository.ListingRepository;
import com.example.Skill.repository.NotificationRepository;
import com.example.Skill.repository.ReviewRepository;
import com.example.Skill.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	private final UserRepository userRepo;
	private final ListingRepository listingRepo;
	private final ReviewRepository reviewRepo;
	private final NotificationRepository notifRepo;
	public ProfileController(UserRepository userRepo, ListingRepository listingRepo, ReviewRepository reviewRepo,
			NotificationRepository notifRepo) {
		this.userRepo = userRepo;
		this.listingRepo = listingRepo;
		this.reviewRepo = reviewRepo;
		this.notifRepo = notifRepo;
	}
	
	@GetMapping
	public String viewLoggedInProfile(HttpSession session, Model model) {
	    User user = (User) session.getAttribute("loggedInUser");
	    if (user == null) return "redirect:/login";

	    Long id = user.getId();
	    model.addAttribute("user", user);
	    model.addAttribute("listings", listingRepo.findAll()
	        .stream().filter(l -> l.getUser().getId().equals(id)).toList());
	    model.addAttribute("reviews", reviewRepo.findAll()
	        .stream().filter(r -> r.getUser().getId().equals(id)).toList());
	    model.addAttribute("notifications", notifRepo.findByUserIdOrderByCreatedAtDesc(id));
	    return "profile";
	}
}
