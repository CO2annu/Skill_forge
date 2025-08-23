package com.example.Skill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Skill.repository.ListingRepository;


@Controller
public class BuyController {
	private final ListingRepository listingRepo;
	public BuyController(ListingRepository listingRepo) {
		this.listingRepo = listingRepo;
	}
	
	@GetMapping("/buy")
	public String showBuyPage(Model model) {
		model.addAttribute("listings", listingRepo.findAll());
		return "buy";
	}
}
