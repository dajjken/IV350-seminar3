package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import integration.CreateSystems;
import integration.ExternalInventorySystem;
import integration.ItemDescription;
import integration.Printer;
import model.DTO.PresentSaleDTO;
import model.DTO.SaleInformation;
import model.POS.Sale;
import model.util.Amount;
import model.util.Change;
import model.util.TotalPrice;

class ControllerTest {
	private CreateSystems systems; 
	private Printer printer; 
	private Controller controllerToTest;
	
	private ExternalInventorySystem inventory;
	private Sale sale;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
		systems = new CreateSystems(); 
		printer  = new Printer(); 
		controllerToTest = new Controller(systems, printer);
		
		this.sale = new Sale();
		this.inventory = systems.getExternalInventorySystem();
	}

	@AfterEach
	void tearDown() throws Exception {
		systems = null;
		printer = null;
		controllerToTest = null;
		sale = null;
		inventory = null;
	}

	@Test
	void testStartSale() {
		TotalPrice testIfSaleIsInitiated = null; 
		testIfSaleIsInitiated = sale.getTotalPrice();
		boolean expectedToBeTrue = false;
		
		if(testIfSaleIsInitiated != null)
			expectedToBeTrue = true;
		assertTrue(expectedToBeTrue, "Sale is created incorrectly");
	}

	@Test
	void testFindItemInInventory() {
		int itemID = 1010;
		String expectedItemName = "Butter";
		ItemDescription returnedItem = inventory.findItem(itemID);
		assertEquals(expectedItemName, returnedItem.getName(), "Wrong item recieved from inventory.");
	}
	
	@Test
	void testIfInvalidIDReturnsNull() {
		int invalidItemID = 1111;
		boolean expectedToBeFalse = true;
		PresentSaleDTO expectedToBeNull = null;
		expectedToBeNull = controllerToTest.findItem(invalidItemID, 4);
		
		if(expectedToBeNull == null)
			expectedToBeFalse = false;
		
		assertFalse(expectedToBeFalse, "Could retrieve item with invalid ID from inventory.");
	}

	@Test
	void testIfNegativeInvalidIDReturnsNull() {
		int negativeInvalidItemID = -47;
		boolean expectedToBeFalse = true;
		PresentSaleDTO expectedToBeNull = null;
		expectedToBeNull = controllerToTest.findItem(negativeInvalidItemID, 10);
		
		if(expectedToBeNull == null)
			expectedToBeFalse = false;
		
		assertFalse(expectedToBeFalse, "Could retrieve item with negative invalid ID from inventory.");
	}
	

	@Test
	void testCorrectChange() {
		ItemDescription testItemSoda = new ItemDescription(new Amount(10), "Soda", 0, 6789);
		ItemDescription testItemCandybar = new ItemDescription(new Amount(15), "Candy-bar", 0, 9876);
		
		sale.addItemToList(testItemSoda, 1);
		sale.addItemToList(testItemCandybar, 1);
		
		Amount amountPaid = new Amount(50);
		Amount expectedChange = new Amount(50 - (10+15));
		
		SaleInformation saleInfoTest = new SaleInformation(sale);
		Change changeTest = new Change(saleInfoTest);
		changeTest.calculateChange(amountPaid);
		
		Amount actualChange = changeTest.getChange();
		
		assertEquals(expectedChange.getValue(), actualChange.getValue(), 
				"Expected change: " + expectedChange.getValue()
				+ " but got: " + actualChange.getValue());

	}
	
}
