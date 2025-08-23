package com.example.Skill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.Skill.repository.SkillRepository;

@Controller
public class BrowseController {
	
	private final SkillRepository skillRepo;
	public BrowseController(SkillRepository skillRepo) {
		this.skillRepo = skillRepo;
	}
	
	@GetMapping("/browse")
	public String browseSkills(Model model) {
		model.addAttribute("skills", skillRepo.findAll());
		return "browse";
	}
}
