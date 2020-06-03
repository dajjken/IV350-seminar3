package integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.util.Amount;

class ItemDescriptionTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEqualID() {
		ItemDescription firstItem = new ItemDescription(new Amount(10), "Milk", 0, 1111);
		ItemDescription secondItem = new ItemDescription(new Amount(10), "Milk", 0, 1111);
	
		boolean expectedToBeTrue = firstItem.equalID(secondItem);
		assertTrue(expectedToBeTrue, "The two descriptions do not have equal ID");
	}

	@Test
	void testNotEqualID() {
		ItemDescription firstItem = new ItemDescription(new Amount(10), "Milk", 0, 1111);
		ItemDescription secondItem = new ItemDescription(new Amount(10), "Lactose free Milk", 0, 2222);
	
		boolean expectedToBeFalse = firstItem.equalID(secondItem);
		assertFalse(expectedToBeFalse, "The two descriptions do have equal ID");
	}
}
