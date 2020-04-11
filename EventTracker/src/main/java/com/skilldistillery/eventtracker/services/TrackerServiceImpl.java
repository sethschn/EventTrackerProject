package com.skilldistillery.eventtracker.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.eventtracker.entities.Emotion;
import com.skilldistillery.eventtracker.entities.Tracker;
import com.skilldistillery.eventtracker.repositories.EmotionRepository;
import com.skilldistillery.eventtracker.repositories.TrackerRepository;

@Service
public class TrackerServiceImpl implements TrackerService {

	@Autowired
	private TrackerRepository trackerRepo;


	@Override
	public Tracker createTracker(Tracker tracker) {
		tracker.setLogDate(LocalDateTime.now());
		return trackerRepo.saveAndFlush(tracker);
	}

	@Override
	public Tracker updateTracker(Tracker tracker, Integer trackerId) {
		Optional<Tracker> optTracker = trackerRepo.findById(trackerId);
		if (optTracker.isPresent()) {
			Tracker managedTracker = optTracker.get();
			if (managedTracker != null) {
				managedTracker.setDescription(tracker.getDescription());		
				managedTracker.setEmotion(tracker.getEmotion());				
				return trackerRepo.saveAndFlush(managedTracker);
			}				
		}
		return null;
	}

	@Override
	public boolean deleteTracker(Integer trackerId) {
		Optional<Tracker> optTracker = trackerRepo.findById(trackerId);
		if (optTracker.isPresent()) {
			Tracker tracker = optTracker.get();
			if (tracker != null) {
				trackerRepo.deleteById(trackerId);				
				return true;				
			}
		}
		return false;
	}

	@Override
	public List<Tracker> listAllEvents() {
		return trackerRepo.findAll();
	}

	@Override
	public Tracker findTrackerById(Integer trackerId) {
		Optional<Tracker> optTracker = trackerRepo.findById(trackerId);
		if (optTracker.isPresent()) {
			Tracker tracker = optTracker.get();
			if (tracker != null) {
				return tracker;
			}
		}
		return null;
	}
	
}
