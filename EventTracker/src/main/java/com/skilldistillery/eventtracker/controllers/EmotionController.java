package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Emotion;
import com.skilldistillery.eventtracker.services.EmotionService;

@RestController
@RequestMapping("api")
public class EmotionController {

	@Autowired
	private EmotionService emotionSvc;

	@GetMapping("emotions")
	public List<Emotion> showAllEmotions() {
		return emotionSvc.listAllEmotions();
	}

	@GetMapping("emotions/{id}")
	public Emotion showEmotionById(@PathVariable("id") Integer id) {
		return emotionSvc.findEmotionById(id);
	}

	@PostMapping("emotions")
	public Emotion createEmotion(@RequestBody Emotion emotion, HttpServletRequest request,
			HttpServletResponse response) {
		emotion = emotionSvc.createEmotion(emotion);
		if (emotion != null) {
			response.setStatus(201);
			StringBuffer reqUrl = request.getRequestURL();
			reqUrl.append("/").append(emotion.getId());
			response.setHeader("Location", reqUrl.toString());
		} else {
			response.setStatus(404);
		}
		return emotion;
	}

	@PutMapping("emotions/{emotionId}")
	public Emotion updateEmotion(@PathVariable Integer emotionId, @RequestBody Emotion emotion,
			HttpServletResponse response) {
		emotion = emotionSvc.updateEmotion(emotion, emotionId);
		if (emotion == null) {
			response.setStatus(404);
		} else {
			response.setStatus(200);
		}
		return emotion;
	}

	@DeleteMapping("emotions/{emotionId}")
	public boolean deleteEmotion(@PathVariable int emotionId, HttpServletResponse response) {
		if (emotionSvc.deleteEmotion(emotionId)) {
			response.setStatus(204);
		} else {
			response.setStatus(404);
		}
		return emotionSvc.deleteEmotion(emotionId);
	}

}
