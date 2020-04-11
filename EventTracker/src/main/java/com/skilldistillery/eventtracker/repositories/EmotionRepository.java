package com.skilldistillery.eventtracker.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.eventtracker.entities.Emotion;


public interface EmotionRepository extends JpaRepository<Emotion, Integer> {
	//List<Comment> findByPostId(Integer id);
	List<Emotion> findByCategory(String category);

}
