package model;

import java.time.LocalTime;
import java.util.ArrayList;

import integration.ItemDescription;

public class Sale {
	
	LocalTime saleTime;
	ArrayList<ItemDescription> itemList = new ArrayList<>();
	ArrayList<Item> itemsInPurchase = new ArrayList<>();
	TotalPrice totalPrice;
	Amount totalVAT;
	
	PresentSaleDTO displaySale;
	
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
	public PresentSaleDTO addItemToList(ItemDescription newItem, int quantity) 
	{
		//itemList.add(item);
		//Item itemToBeAdded = new Item(item, 1);
		updateList(newItem, quantity);
		updateTotalPrice(newItem, quantity);
		
		return new PresentSaleDTO(newItem, totalPrice);
		
	}


	private void updateTotalPrice(ItemDescription item, int quantity)
	{
		totalPrice.addToTotalPrice(item.getPrice().multiplyAmount(quantity));
	}
	
	private void updateList(ItemDescription checkedItem, int quantity)
	{
		if(this.itemIsInList(checkedItem)) 
		{
			for(Item item: itemsInPurchase)
			{
				if(item.itemDesc.equals(checkedItem))				
				{
					item.updateQuantity(quantity);
				}
			}
		}	
		else
		{
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

