package com.example.Skill.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Skill.entity.Listing;
import com.example.Skill.entity.Skill;
import com.example.Skill.entity.User;
import com.example.Skill.repository.ListingRepository;
import com.example.Skill.repository.SkillRepository;
import com.example.Skill.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/sell")
public class SellController {
	private final ListingRepository listingRepo;
	private final SkillRepository skillRepo;
	private final UserRepository userRepo;
	public SellController(ListingRepository listingRepo, SkillRepository skillRepo, UserRepository userRepo) {
		this.listingRepo = listingRepo;
		this.skillRepo = skillRepo;
		this.userRepo = userRepo;
	}
	
	@GetMapping
	public String showSellForm(HttpSession session, Model model) {
	    User user = (User) session.getAttribute("loggedInUser");
	    if (user == null) return "redirect:/login";

	    model.addAttribute("listing", new Listing());
	    model.addAttribute("skills", skillRepo.findAll());
	    model.addAttribute("users", List.of(user)); // only show current user
	    return "sell";
	}

	@PostMapping
	public String createListing(@ModelAttribute Listing listing,
	                            @RequestParam Long userId,
	                            @RequestParam Long skillId,
	                            HttpSession session) {
	    User sessionUser = (User) session.getAttribute("loggedInUser");
	    if (sessionUser == null || !sessionUser.getId().equals(userId)) {
	        return "redirect:/login";
	    }

	    User user = userRepo.findById(userId).orElseThrow();
	    Skill skill = skillRepo.findById(skillId).orElseThrow();

	    listing.setUser(user);
	    listing.setSkill(skill);
	    listing.setCreatedAt(LocalDateTime.now());
	    listingRepo.save(listing);

	    return "redirect:/marketplace";
	}
}
