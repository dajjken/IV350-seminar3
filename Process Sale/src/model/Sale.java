package model;

import java.time.LocalTime;
import java.util.ArrayList;

import integration.ItemDescription;

/**
 * This class represents a purchase of goods made by a single customer.
 * @author danie
 *
 */
public class Sale {
	
	LocalTime saleTime;
	ArrayList<Item> itemsInPurchase = new ArrayList<>();
	TotalPrice totalPrice;
	Amount totalVAT;
	
	PresentSaleDTO displaySale;
	
	/**
	 * Creates a new instance.
	 */
	public Sale()
	{
		saleTime = LocalTime.now();
		totalPrice = new TotalPrice();
		
		System.out.println("Sale started in: " + saleTime);
	}
	
	/**
	 * Adds a item to the list of goods to be purchased
	 * @param newItem The item to be added
	 * @param quantity Number of items to be added
	 */
	public PresentSaleDTO addItemToList(ItemDescription newItem, int quantity) {
		updateList(newItem, quantity);
		updateTotalPrice(newItem, quantity);
		
		return new PresentSaleDTO(newItem, totalPrice);
	}

	private void updateTotalPrice(ItemDescription item, int quantity) {
		totalPrice.addToTotalPrice(item.getPrice().multiplyAmount(quantity));
	}
	
	private void updateList(ItemDescription checkedItem, int quantity) {
		if(this.itemIsInList(checkedItem)) {
			for(Item item: itemsInPurchase) {
				if(item.itemDesc.equals(checkedItem)) {
					item.updateQuantity(quantity);
				}
			}
		}	
		else {
			itemsInPurchase.add(new Item(checkedItem, quantity));
		}		
	}
	
	private boolean itemIsInList(ItemDescription checkedItem)
	{
		for(Item item: itemsInPurchase)
		{
			if(item.itemDesc.equals(checkedItem))				
				return true;
		}	
			
		return false;
	}
	
	
	/**
	 * 
	 */
	public SaleInformation stopSale() {
		SaleInformation saleInfo = new SaleInformation(this);
		return saleInfo;
	}
	
	/**
	 * Temporary printfunction
	 */
	private void printList() 
	{	
		for(Item item: itemsInPurchase)
		{
			System.out.println(item.toString());
		}	
		System.out.println("Total price:" + totalPrice.toString());
	}
	
	/**
	 *  Returns the itemList as a string, will be used when printing receipt.
	 * @return String representation of the list if items.
	 */
	public String itemsToString() {
		StringBuilder builder = new StringBuilder();
		
		for(Item item: itemsInPurchase)
		{
			builder.append(item.toString()+"\n");
		}	
		
		return builder.toString();
	}
	
	/**
	 * 
	 * @return The total price as an Amount-type.
	 */
	public Amount getTotalPrice() {
		return totalPrice.amount;
	}
	
}

