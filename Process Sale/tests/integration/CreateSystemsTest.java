package integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CreateSystemsTest {
	
	CreateSystems systems;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		systems = new CreateSystems();
	}

	@AfterEach
	void tearDown() throws Exception {
		systems = null;
	}

	@Test
	void testConstructor() {
		Boolean expectedToBeTrue = false;
		if((systems.getDiscountSystem() instanceof DiscountSystem) &&
			(systems.getExternalAccountingSystem() instanceof ExternalAccountingSystem)
			&& (systems.getSaleLog() instanceof SaleLog ) &&
			(systems.getExternalInventorySystem() instanceof ExternalInventorySystem))
			expectedToBeTrue = true;
		
		assertTrue(expectedToBeTrue, "Wrong instances created"); 
	}

}
