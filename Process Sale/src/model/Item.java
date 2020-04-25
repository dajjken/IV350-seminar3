package model;

import integration.ItemDescription;

public class Item {
	
	ItemDescription itemDesc;
	int quantity;
	
	public Item(ItemDescription itemDesc, int quantity)
	{
		this.itemDesc = itemDesc;
		this.quantity = quantity;
	}
	
	public ItemDescription getItemDescription()
	{
		return itemDesc;
	}
	
	void updateQuantity(int addQuantity)
	{
		this.quantity = this.quantity + addQuantity;
	}

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
