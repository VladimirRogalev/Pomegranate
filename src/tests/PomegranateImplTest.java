package tests;



import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.PomegranateImpl;
import model.Box;

class PomegranateImplTest {
	
	PomegranateImpl granates;
	List<Box> boxes;
	 

	@BeforeEach
	void setUp() throws Exception {
		granates = new PomegranateImpl();
		boxes =granates.generateRandomBoxes();
	}

	@Test
	void testGenerateRandomBoxes() {
		List<Box> boxes =granates.generateRandomBoxes();
		assertNotNull(boxes);
		assertTrue(boxes.size()>= 100 && boxes.size()<=200);
		System.out.println(boxes.size());
	}
	
	@Test
	void testCalculateTotalSeeds() {
		int totalSeeds = granates.calculateTotalSeeds(boxes);
		assertNotNull(totalSeeds);
		granates.fiveMaxBoxes(boxes);
		System.out.println("Total seeds: " + totalSeeds);
		
	}
	@Test
	void testCalculateMaxSeeds() {
		int maxSeeds = granates.calculateMaxSeeds(boxes);
		assertNotNull(maxSeeds);
		System.out.println("Max seeds: " + maxSeeds);
		
	}

}
