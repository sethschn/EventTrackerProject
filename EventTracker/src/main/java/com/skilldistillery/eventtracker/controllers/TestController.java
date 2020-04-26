package com.skilldistillery.eventtracker.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@CrossOrigin({ "*", "http://localhost:4202" })
public class TestController {
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}

}
