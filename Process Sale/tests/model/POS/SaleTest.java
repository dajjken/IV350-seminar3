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
	
	ArrayList<Item> testingListOfItems = new ArrayList<>();

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
	void testAddItemToEmptyList() {
		Sale testSale = new Sale();
		
		
		
		ItemDescription fakeTestingItem = new ItemDescription(new Amount(16), "Milk", 0.25, 1010);
		String expResult = fakeTestingItem.getName();

		testSale.addItemToList(fakeTestingItem, 10);
		String result = testSale.itemsInPurchase.get(0).getItemDescription().getName();
		
		assertEquals(expResult,result, "Adding item to empty list not working");
	}

	@Test
	void testStopSale() {
		Sale testSale = new Sale();
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
	
	

}
