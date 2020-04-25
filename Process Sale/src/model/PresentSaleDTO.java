package model;

import integration.ItemDescription;

public class PresentSaleDTO {

	private ItemDescription mostRecentScannedItem;
	TotalPrice totalPrice;
	
	
	public PresentSaleDTO(ItemDescription scannedItem, TotalPrice totalPrice)
	{
		this.mostRecentScannedItem = scannedItem;
		this.totalPrice = totalPrice;
	}
	
	
	public String toString()
	{
		return mostRecentScannedItem.getName() + "\t\t\t" + mostRecentScannedItem.getPrice()
				+"\nTotal Price: \t\t" + totalPrice.toString();
	}
}
