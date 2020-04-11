package com.skilldistillery.eventtracker.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrackerTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Tracker tracker;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("EventTrackerPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		tracker = em.find(Tracker.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		tracker = null;
	}

	@Test
	void test_Tracker_entity_mapping() {
		assertNotNull(tracker);
		assertEquals(LocalDateTime.of(2020, 04, 11, 01, 00), tracker.getLogDate());
		System.out.println(tracker);
	}

}
