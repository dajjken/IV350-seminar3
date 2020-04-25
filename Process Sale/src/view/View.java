package view;

import controller.Controller;
import model.Amount;
import model.PresentSaleDTO;
import model.SaleInformation;

import java.util.Scanner;

public class View {
	
	
	Controller controller;

	
	public View(Controller controller)
	{
		this.controller = controller;
		
	}

	
	/**
	 * 
	 * This method simulates a purchase. The user enters the id of the item, and 
	 * the quantity of that item. To end the input of item, enter "0".
	 * 
	 * The available items to enter are:
	 * 1010 - Milk
	 * 2020 - Bread
	 * 3030 - Flour
	 * 4040 - Pasta
	 * 5050 - Coffe
	 * 6060 - Cheese
	 * 
	 */
	public void testRun() {
		
		Scanner input = new Scanner(System.in);
		PresentSaleDTO displaySale;
		SaleInformation saleInfo;
		
		controller.startSale();
		int itemID = 1;
		int quantity = 1;
		
		while(itemID!= 0) {
			System.out.println("Enter itemID: ");
			itemID = input.nextInt(); 
			
			if(itemID==0)
				break;
			
			System.out.println("No of items: ");
			quantity = input.nextInt(); 
			
			displaySale = controller.findItem(itemID, quantity);
			System.out.println(displaySale.toString());
		}
		
		saleInfo = controller.stopSale();
		
		System.out.println("Checking discount...");
		System.out.println("No discount available.");
		
		
		System.out.println("Enter amount paid in cash: ");
		 quantity = input.nextInt();
		System.out.println("Printing Receipt...\n");
		controller.enterAmountPaid(new Amount(quantity));
	}
	
	
	/**
	 * Simulates a purchase made by a single customer
	 */
	public void hardcodedTestRun() {
		
		PresentSaleDTO displaySale;
		SaleInformation saleInfo;
		Scanner input;
		
		controller.startSale();
	
		for(int i = 1; i<7; i++)
		{
			displaySale = controller.findItem(i*1010, i);
			
			System.out.println(displaySale.toString()+"\n");
		}
		
		saleInfo=controller.stopSale();
		
		System.out.println("Checking discount...");
		
		
		System.out.println("Enter amount paid in cash: 1000");
		System.out.println("Change: " + controller.enterAmountPaid(new Amount(1000)));
		
		
		
		/**
		 * 		ADD CHECKDISCOUNT!!!!!!!!!!!!!!!
		 */
		
		

	
	}
	
}
