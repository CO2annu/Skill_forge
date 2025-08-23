package com.example.Skill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Skill.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
	List<Review> findByListingId(Long listingId);
}
