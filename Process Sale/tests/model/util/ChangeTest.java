package model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import integration.ItemDescription;
import model.DTO.SaleInformation;
import model.POS.Sale;

class ChangeTest {
	Sale sale;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		this.sale = new Sale();
		
	}
	

	@AfterEach
	void tearDown() throws Exception {
		sale = null;
	}

	@Test
	void testCalculateChange() {
		ItemDescription testItemApple = new ItemDescription(new Amount(7), "Apple", 0, 9999);
		ItemDescription testItemTomato = new ItemDescription(new Amount(5), "Tomato", 0, 8888);
		
		sale.addItemToList(testItemApple, 2);
		sale.addItemToList(testItemTomato, 4);
		
		Amount paidAmount = new Amount(100);
		Amount expectedChange = new Amount(100 - ((7*2)+(5*4)));
		
		SaleInformation saleInfoTest = new SaleInformation(sale);
		Change changeTest = new Change(saleInfoTest);
		changeTest.calculateChange(paidAmount);
		
		Amount actualChange = changeTest.getChange();
		
		assertEquals(expectedChange.getValue(), actualChange.getValue(), 
				"Calculate change not working. Expected change: " + expectedChange.getValue()
				+ " but got: " + actualChange.getValue());
	}

}
