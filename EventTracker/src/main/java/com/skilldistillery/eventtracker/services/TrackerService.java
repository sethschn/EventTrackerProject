package com.skilldistillery.eventtracker.services;

import java.util.List;

import com.skilldistillery.eventtracker.entities.Emotion;
import com.skilldistillery.eventtracker.entities.Tracker;

public interface TrackerService {

	List<Tracker> listAllEvents();

	Tracker findTrackerById(Integer id);

	Tracker createTracker(Tracker tracker, Integer emotionId);

	Tracker updateTracker(Tracker tracker, Integer trackerId);

	boolean deleteTracker(Integer trackerId);

}
