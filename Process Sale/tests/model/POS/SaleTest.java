package model.POS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import integration.ItemDescription;
import model.DTO.PresentSaleDTO;
import model.DTO.SaleInformation;
import model.util.Amount;

class SaleTest {
	
	Sale testSale;
	
	ArrayList<Item> testingListOfItems = new ArrayList<>();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		testSale = new Sale();
	}

	@AfterEach
	void tearDown() throws Exception {
		testSale = null;
	}

	@Test
	void testAddItemToEmptyList() {
		
		ItemDescription fakeTestingItem = new ItemDescription(new Amount(16), "Milk", 0.25, 1010);
		String expResult = fakeTestingItem.getName();

		testSale.addItemToList(fakeTestingItem, 10);
		String result = testSale.getItemsInPurchase().get(0).getItemDescription().getName();
		
		assertEquals(expResult,result, "Adding item to empty list not working");
	}
	
	@Test
	void testStopSale() {
		ItemDescription fakeTestingItem = new ItemDescription(new Amount(16), "Milk", 0.25, 1010);
		ItemDescription anotherFakeTestingItem = new ItemDescription(new Amount(200), "Candy", 0.25, 2020);
		testSale.addItemToList(fakeTestingItem, 10);
		testSale.addItemToList(anotherFakeTestingItem, 3);
		
		SaleInformation expSaleInfo = new SaleInformation(testSale);
		SaleInformation resultSaleInfo = testSale.stopSale();
		
		boolean resultExpectedToBeTrue = false;
	
		if(expSaleInfo.getTotalPrice().getFinalPrice().getValue() ==
				(resultSaleInfo.getTotalPrice().getFinalPrice().getValue())
				&& expSaleInfo.getDate().equals(resultSaleInfo.getDate())
				&& expSaleInfo.getItemListAsString().equals(resultSaleInfo.getItemListAsString())) {
			resultExpectedToBeTrue = true;
		}
		assertTrue(resultExpectedToBeTrue, "Stop sale not working. Wont return correct SaleInformation" );
	}
	
	@Test
	void testAddItemToNotEmptyList() {
		
		ItemDescription testingItem = new ItemDescription(new Amount(16), "Milk", 0.25, 1010);
		ItemDescription anotherTestingItem = new ItemDescription(new Amount(7), "Apple", 0, 9999);
		ItemDescription yetAnotherTestingItem = new ItemDescription(new Amount(2), "Banana", 0, 8888);

		testSale.addItemToList(testingItem, 10);
		testSale.addItemToList(anotherTestingItem, 4);
		testSale.addItemToList(yetAnotherTestingItem, 2);
		boolean expectedtoBeTrue = false;
		ArrayList<Item> listOfItemsInSale = testSale.getItemsInPurchase();
		
		if( (listOfItemsInSale.get(0).getItemDescription().equalID(testingItem)) && 
		(listOfItemsInSale.get(1).getItemDescription().equalID(anotherTestingItem)) &&
		(listOfItemsInSale.get(2).getItemDescription().equalID(yetAnotherTestingItem)) ) {
			expectedtoBeTrue = true;
		}

		assertTrue(expectedtoBeTrue, "Adding item to list not working");
	}
	
	@Test
	void testAddSameItem() {
		ItemDescription testingItem = new ItemDescription(new Amount(16), "Milk", 0.25, 1010);
		int firstQuantity = 4;
		int newQuantity = 8;
		int expectedQuantity = newQuantity + firstQuantity;
		testSale.addItemToList(testingItem, firstQuantity);
		testSale.addItemToList(testingItem, newQuantity);
		int actualQuantity = testSale.getItemsInPurchase().get(0).getQuantity();
		assertEquals(expectedQuantity, actualQuantity, "Expected quantity and actual quantity does not match");
	}
	
	@Test
	void testIfMostRecentItemIsReturned() {
		
		ItemDescription firstItem = new ItemDescription(new Amount(16), "Milk", 0.25, 1010);
		ItemDescription secondItem = new ItemDescription(new Amount(7), "Apple", 0, 9999);
		ItemDescription thirdItem = new ItemDescription(new Amount(2), "Banana", 0, 8888);
		
		PresentSaleDTO recentItemDTO = null;
		
		recentItemDTO = testSale.addItemToList(firstItem, 1);
		recentItemDTO = testSale.addItemToList(secondItem, 2);
		recentItemDTO = testSale.addItemToList(thirdItem, 3);
		
		Item recentItem = new Item(thirdItem, 3);
		PresentSaleDTO excpectedItem = new PresentSaleDTO(recentItem, testSale.getTotalPrice());
		
		assertEquals(excpectedItem.getItem(), recentItem," Expected Item does not match actual item");
		
	}

	
}
