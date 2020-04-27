package model.DTO;

import integration.ItemDescription;
import model.POS.Item;
import model.util.TotalPrice;

public class PresentSaleDTO {

	private Item mostRecentScannedItem;
	TotalPrice totalPrice;
	//int quantity;

	public PresentSaleDTO(Item scannedItem, TotalPrice totalPrice) {
		this.mostRecentScannedItem = scannedItem;
		this.totalPrice = totalPrice;
		
	}
	
	public String toString()
	{
		if(mostRecentScannedItem.getQuantity()>1) {
		return mostRecentScannedItem.getItemDescription().getName() + "\t\t"
		+mostRecentScannedItem.getQuantity()+"*\t"+ mostRecentScannedItem.getItemDescription().getPrice()
			+"\nVAT for this item: " + mostRecentScannedItem.getItemDescription().getVATCost()		
			+"\nTotal Price: \t\t" + totalPrice.addPriceAndVAT()+"\n";
		}
		else
			return mostRecentScannedItem.getItemDescription().getName() + "\t\t\t"
				+ mostRecentScannedItem.getItemDescription().getPrice()
				+"\nVAT for this item: " + mostRecentScannedItem.getItemDescription().getVATCost()		
				+"\nTotal Price: \t\t" + totalPrice.addPriceAndVAT()+"\n";
	}
/*	
	public PresentSaleDTO(ItemDescription scannedItem, TotalPrice totalPrice, int quantity)
	{
		this.mostRecentScannedItem = scannedItem;
		this.totalPrice = totalPrice;
		this.quantity =  quantity;
	}
	
	
	public String toString()
	{
		if(quantity>1) {
		return mostRecentScannedItem.getName() + "\t\t"+quantity+"*\t"+ mostRecentScannedItem.getPrice()
			+"\nVAT for this item: " + mostRecentScannedItem.getVATCost()		
			+"\nTotal Price: \t\t" + totalPrice.addPriceAndVAT()+"\n";
		}
		else
			return mostRecentScannedItem.getName() + "\t\t\t"+ mostRecentScannedItem.getPrice()
			+"\nVAT for this item: " + mostRecentScannedItem.getVATCost()		
			+"\nTotal Price: \t\t" + totalPrice.addPriceAndVAT()+"\n";
	}
*/
}
