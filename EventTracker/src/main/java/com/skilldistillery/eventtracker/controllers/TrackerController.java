package com.skilldistillery.eventtracker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.eventtracker.entities.Tracker;
import com.skilldistillery.eventtracker.services.TrackerService;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4202" })
public class TrackerController {
	
	@Autowired
	private TrackerService trackerSvc;
	
	@GetMapping("trackers")
	public List<Tracker> showAllTrackers() {
		return trackerSvc.listAllEvents();
	}

	@GetMapping("trackers/{id}")
	public Tracker showTrackerById(@PathVariable("id") Integer id) {
		return trackerSvc.findTrackerById(id);
	}

	@PostMapping("trackers/{emotionId}")
	public Tracker createTracker(@PathVariable("emotionId") Integer id, @RequestBody Tracker tracker, HttpServletRequest request,
			HttpServletResponse response) {
		tracker = trackerSvc.createTracker(tracker,id);
		if (tracker != null) {
			response.setStatus(201);
			StringBuffer reqUrl = request.getRequestURL();
			reqUrl.append("/").append(tracker.getId());
			response.setHeader("Location", reqUrl.toString());
		} else {
			response.setStatus(404);
		}
		return tracker;
	}

	@PutMapping("trackers/{trackerId}")
	public Tracker updateTracker(@PathVariable Integer trackerId, @RequestBody Tracker tracker,
			HttpServletResponse response) {
		tracker = trackerSvc.updateTracker(tracker, trackerId);
		if (tracker == null) {
			response.setStatus(404);
		} else {
			response.setStatus(200);
		}
		return tracker;
	}

	@DeleteMapping("trackers/{trackerId}")
	public boolean deleteTracker(@PathVariable int trackerId, HttpServletResponse response) {
		if (trackerSvc.deleteTracker(trackerId)) {
			response.setStatus(204);
		} else {
			response.setStatus(404);
		}
		return trackerSvc.deleteTracker(trackerId);
	}

}
