package com.skilldistillery.eventtracker.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmotionTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Emotion emotion;

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
		emotion = em.find(Emotion.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		emotion = null;
	}

	@Test
	void test_Emotion_entity_mapping() {
		assertNotNull(emotion);
		assertEquals("Affection", emotion.getName());
		//System.out.println(emotion);
	}

}
