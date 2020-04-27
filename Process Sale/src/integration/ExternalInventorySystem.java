package integration;

import java.util.ArrayList;

import model.DTO.SaleInformation;
import model.util.Amount;

public class ExternalInventorySystem {
	
//	private ExternalInventorySystem inventory;
	private ArrayList<ItemDescription> goodsInStock = new ArrayList<ItemDescription>();

	public ExternalInventorySystem() {
		
		addGoods();
		//System.out.println("Inventory created");	
	}
/*
	public ExternalInventorySystem getExternalInventorySystem()
	{
		return this;
	}
*/	
	
	/**
	 * Searches the database for a certain item.
	 * @param itemID Represents the item searched for.
	 * @return the description of the found item. Returns null if item is not found.
	 */
	public ItemDescription findItem(int itemID)
	{
		
		for(ItemDescription item: goodsInStock)
		{
			if(item.getItemID() == itemID)
			{
				return item;
			}
			
			
		}	
		return null;
	}
	
	private void printList() {
		for(ItemDescription item: goodsInStock)
		{
			System.out.println(item);
		}
	}
	/**
	 * Updates the inventory after sale is completed, not implemented
	 */
	public void updateInventory(SaleInformation saleInfo) {
		//some code
	}
	
	private void addGoods() {
		goodsInStock.add(new ItemDescription(new Amount(50), "Butter", 0.06, 1010));
		goodsInStock.add(new ItemDescription(new Amount(25), "Bread", 0.12, 2020));
		goodsInStock.add(new ItemDescription(new Amount(10), "Flour", 0.12, 3030));
		goodsInStock.add(new ItemDescription(new Amount(20), "Pasta", 0.12, 4040));
		goodsInStock.add(new ItemDescription(new Amount(35), "Coffee", 0.25, 5050));
		goodsInStock.add(new ItemDescription(new Amount(85), "Cheese", 0.12, 6060));
	
	}

	
}
