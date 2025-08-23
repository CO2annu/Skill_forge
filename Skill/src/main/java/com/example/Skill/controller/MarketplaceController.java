package com.example.Skill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Skill.repository.ListingRepository;

@Controller
public class MarketplaceController {
	private final ListingRepository listingRepo;
	
	public MarketplaceController(ListingRepository listingRepo) {
		this.listingRepo = listingRepo;
	}
	@GetMapping("/marketplace")
	public String viewMarketPlace(Model model) {
		model.addAttribute("listings", listingRepo.findAll());
		return "marketplace";
	}
}
