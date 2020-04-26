package integration;

import model.Amount;

/**
 * This class represents an item, and its information 
 * stored in an external database.
 * 
 *
 */
public class ItemDescription {
	
	private Amount price; 
	private String name;
	private double VATRate;
	private int itemID;
	
	public ItemDescription() {	
		
	}
	
	/**
	 * Creates a new instance of this type.
	 * @param price The price of the item.
	 * @param name The name of the item.
	 * @param VATRate The VAT-rate of the item.
	 * @param itemID THe itemID of the item. Could represent a barcode or something similar.
	 */
	public ItemDescription(Amount price, String name, double VATRate, int itemID) {
		this.price = price;
		this.name = name;
		this.VATRate = VATRate;
		this.itemID = itemID;
		
	}
	
	/**
	 *  Returns the itemID of the current ItemDescription-object.
	 * @return the itemID of this instance.
	 */
	public int getItemID()
	{
		return this.itemID;
	}
	
	/**
	 * Returns the price as an Amount-object.
	 * @return the price of this instance.
	 */
	public Amount getPrice()
	{
		return this.price;
	}
	
	/**
	 * 
	 * @return the name of this instance
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Returns the VAT-rate of the current object. 
	 * @return The VAT rate as a double.
	 */
	public double getVATRate() {
		return this.VATRate;
	}
	
	/**
	 *  TEMPORARY, REMOVE LATER!!!!!!!!!!!!!!!!!
	 */
	public String toString()
	{
		return this.name + " id: " + this.itemID;
		
	}
}
