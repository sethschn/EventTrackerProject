package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Emotion;
import com.skilldistillery.eventtracker.services.EmotionService;

@RestController
@RequestMapping("api")
public class TrackerController {
	
	@Autowired
	private EmotionService emotionSvc;
	
	@GetMapping("emotions")
	public List<Emotion> showAllEmotions() {	
		return emotionSvc.listAllEmotions();
	}
	
	@PostMapping("emotions")
	public String createEmotion() {
		return "pong";
	}

}
