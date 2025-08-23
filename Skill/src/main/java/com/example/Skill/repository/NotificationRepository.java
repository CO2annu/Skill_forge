package com.example.Skill.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Skill.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long>{
	List<Notification> findByUserIdOrderByCreatedAtDesc(Long userId);
}
