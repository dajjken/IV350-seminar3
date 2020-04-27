package view;

import controller.Controller;
import model.Amount;
import model.PresentSaleDTO;
import model.SaleInformation;

import java.util.Scanner;

public class View {
	
	Controller controller;

	/**
	 * Creates a new instance.
	 * @param controller
	 */
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
	public void userTestRun() {
		
		Scanner input = new Scanner(System.in);
		
		controller.startSale();

		userScanningItems();

		SaleInformation saleInfo = controller.stopSale();
		
		System.out.println("Checking discount...");
		controller.checkDiscount(0, saleInfo);
		
		System.out.println("Enter amount paid in cash: ");
		int amountPaid = input.nextInt();
		
		System.out.println("Printing Receipt...\n");
		controller.enterAmountPaid(new Amount(amountPaid));
		
	}
	
	private void userScanningItems() {
		Scanner input = new Scanner(System.in);
		PresentSaleDTO displaySale;
		
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
	}
	
	/**
	 * Simulates a purchase made by a single customer
	 */
	public void hardcodedTestRun() {
		
		
		SaleInformation saleInfo;
		
		controller.startSale();
	
		addItemsInLoop();
		
		saleInfo=controller.stopSale();
		
		System.out.println("Checking discount...");
		controller.checkDiscount(0, saleInfo);
		
		System.out.println("Enter amount paid in cash: 1000");
		controller.enterAmountPaid(new Amount(1000));
	}
	
	private void addItemsInLoop() {
		PresentSaleDTO displaySale;
		
		for(int i = 1; i<7; i++)
		{
			displaySale = controller.findItem(i*1010, i);
			
			System.out.println(displaySale.toString()+"\n");
		}
	}
	
}
