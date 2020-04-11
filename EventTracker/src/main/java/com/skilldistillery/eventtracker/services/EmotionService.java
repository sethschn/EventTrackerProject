package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Emotion;

public interface EmotionService {

	List<Emotion> listAllEmotions();

	Emotion findEmotionById(Integer id);
	
	List<Emotion> findEmotionByCategory(String category);

	Emotion createEmotion(Emotion emotion);

	Emotion updateEmotion(Emotion emotion, Integer emotionId);

	boolean deleteEmotion(Integer emotionId);

}
