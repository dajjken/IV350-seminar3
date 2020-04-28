package model.POS;

import integration.ItemDescription;
/**
 * This class represent a type of item being purchased
 *
 */
public class Item {
	
	ItemDescription itemDesc;
	int quantity;
	
	/**
	 * Creates an instance.
	 * @param itemDesc Represents the items description stored in the database.
	 * @param quantity The quantity of the item being purchased.
	 */
	public Item(ItemDescription itemDesc, int quantity)
	{
		this.itemDesc = itemDesc;
		this.quantity = quantity;
	}
	
	/**
	 * 
	 * @return the ItemDescription of the current instance.
	 */
	public ItemDescription getItemDescription()
	{
		return itemDesc;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * 
	 * @param addQuantity Represents the quantity being added to the current instance.
	 */
	public void updateQuantity(int addQuantity)
	{
		this.quantity = this.quantity + addQuantity;
	}
	
	/**
	 *  Returns the object as a String.
	 */
	public String toString()
	{
		if(quantity>1)
			return itemDesc.getName() + "\t"+quantity+"*" + itemDesc.getPrice() + "\t" + itemDesc.getPrice().multiplyAmount(quantity);
		else if(quantity==0)
			return "";
		else
			return itemDesc.getName() + "\t\t" + itemDesc.getPrice();
	}
}
