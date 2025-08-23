package com.example.Skill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Skill.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
