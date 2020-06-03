package integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExternalInventorySystemTest {
	
	ExternalInventorySystem inventoryToTest;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		inventoryToTest = new ExternalInventorySystem();
	}

	@AfterEach
	void tearDown() throws Exception {
		inventoryToTest = null;
	}

	@Test
	void testFindItemWithWorkingID() {
		int validID = 1010;
		String expectedName = "Butter";
		ItemDescription itemDesc = inventoryToTest.findItem(validID);
		
		String actualName = itemDesc.getName();
		
		assertEquals(expectedName, actualName,"Expected name does not match actual name");
		
	}
	
	@Test
	void testFindItemInvalidID() {
		int invalidID = 1111;
		
		ItemDescription nullItem = null;
		ItemDescription expectedToBeNull = inventoryToTest.findItem(invalidID);

		assertEquals(expectedToBeNull, nullItem,"Should return null, not an itemDescription-object");
		
	}

}
