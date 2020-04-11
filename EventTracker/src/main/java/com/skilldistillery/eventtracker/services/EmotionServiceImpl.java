package com.skilldistillery.eventtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Emotion;
import com.skilldistillery.eventtracker.repositories.EmotionRepository;

@Service
public class EmotionServiceImpl implements EmotionService {

	@Autowired
	private EmotionRepository emotionRepo;


	@Override
	public Emotion createEmotion(Emotion emotion) {
		return emotionRepo.saveAndFlush(emotion);
	}

	@Override
	public Emotion updateEmotion(Emotion emotion, Integer emotionId) {
		Optional<Emotion> optEmotion = emotionRepo.findById(emotionId);
		if (optEmotion.isPresent()) {
			Emotion managedEmotion = optEmotion.get();
			if (managedEmotion != null) {
				managedEmotion.setCategory(emotion.getCategory());			
				managedEmotion.setDescription(emotion.getDescription());			
				managedEmotion.setName(emotion.getName());	
				return emotionRepo.saveAndFlush(managedEmotion);
			}				
		}
		return null;
	}

	@Override
	public boolean deleteEmotion(Integer emotionId) {
		Optional<Emotion> optEmotion = emotionRepo.findById(emotionId);
		if (optEmotion.isPresent()) {
			Emotion emotion = optEmotion.get();
			if (emotion != null) {
				emotionRepo.deleteById(emotionId);				
			}
			return true;				
		}
		return false;
	}

	@Override
	public List<Emotion> listAllEmotions() {
		return emotionRepo.findAll();
	}

	@Override
	public Emotion findEmotionById(Integer emotionId) {
		Optional<Emotion> optEmotion = emotionRepo.findById(emotionId);
		if (optEmotion.isPresent()) {
			Emotion emotion = optEmotion.get();
			if (emotion != null) {
				return emotion;
			}
		}
		return null;
	}

	@Override
	public List<Emotion> findEmotionByCategory(String category) {
		return emotionRepo.findByCategory(category);
	}
	
}
