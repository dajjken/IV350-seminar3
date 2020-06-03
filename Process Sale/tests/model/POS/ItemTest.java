package model.POS;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import integration.ItemDescription;
import model.util.Amount;

class ItemTest {
	
	Item itemToTest;
	ItemDescription testItemDescApple;
	int quantity = 9;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		testItemDescApple = new ItemDescription(new Amount(7), "Apple", 0, 9999);
		itemToTest = new Item(testItemDescApple, quantity);
	}

	@AfterEach
	void tearDown() throws Exception {
		testItemDescApple = null;
	}

	@Test
	void testGetItemDescription() {
		
		ItemDescription expectedDesc = new ItemDescription(new Amount(7), "Apple", 0, 9999);
		ItemDescription actualDesc = itemToTest.getItemDescription(); 
		
		assertEquals(expectedDesc.getPrice().getValue(), actualDesc.getPrice().getValue(),
							"Expected price " + expectedDesc.getPrice().getValue() + 
							" does not match actual price " + actualDesc.getPrice().getValue());
		assertEquals(expectedDesc.getName(), actualDesc.getName(),
				"Expected name " + expectedDesc.getName() + 
				" does not match actual name " + actualDesc.getName());
		assertEquals(expectedDesc.getItemID(), actualDesc.getItemID(),
				"Expected ID " + expectedDesc.getItemID() + 
				" does not match actual ID " + actualDesc.getItemID());
	}

	@Test
	void testGetQuantity() {
		
		int expectedQuantity = 9;
		int actualQuantity = itemToTest.getQuantity();
		
		assertEquals(expectedQuantity, actualQuantity, 
				"Expected quantity " + expectedQuantity + 
				"does not match actual quantity : " + actualQuantity);
	}

	@Test
	void testUpdateQuantity() {
		int newQuantity = 12;
		int expectedQuantity = 9 + 12;
		itemToTest.updateQuantity(newQuantity);
		int actualQuantity = itemToTest.getQuantity();
		
		assertEquals(expectedQuantity, actualQuantity, 
				"Expected quantity " + expectedQuantity + 
				"does not match actual quantity : " + actualQuantity);
	}

	@Test
	void testToString() {
				
		String s1 = "Apple";
		boolean expectedToBeTrue = itemToTest.toString().contains(s1);
		
		assertTrue(expectedToBeTrue, "String does not contain name");
	}

}
