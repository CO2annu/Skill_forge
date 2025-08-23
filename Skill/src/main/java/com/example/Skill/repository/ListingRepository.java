package com.example.Skill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Skill.entity.Listing;

public interface ListingRepository extends JpaRepository<Listing , Long>{

}
