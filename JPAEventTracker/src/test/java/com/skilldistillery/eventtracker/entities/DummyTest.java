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

class DummyTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Dummy dummy;

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
		dummy = em.find(Dummy.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		dummy = null;
	}

	@Test
	void test_Dummy_entity_mapping() {
		assertNotNull(dummy);
		assertEquals("Frog", dummy.getName());
	}

}
