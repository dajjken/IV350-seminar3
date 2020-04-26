package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import integration.ItemDescription;

public class SaleInformation {
	
	private ArrayList <Item> itemList = new ArrayList<>();
	private ItemDescription mostRecentScannedItem;
	LocalTime saleTime;
	LocalDate date;
	TotalPrice totalPrice;
	Amount totalVAT;
	Amount amountPaid;
	Amount change;
	String itemListAsString;
	
	public SaleInformation(Sale sale)
	{
		this.itemList = sale.itemsInPurchase;
		this.saleTime = sale.saleTime;
		this.date = LocalDate.now();
		this.totalPrice = sale.totalPrice;
		this.totalVAT = sale.totalVAT;
		this.itemListAsString = sale.itemsToString(); 
	}
	
	/**
	 * Temporary printmethod
	 */
	
	public void printList() 
	{	
		for(Item item: itemList)
		{
			System.out.println(item.toString());
		}	
		System.out.println("Total price:" + getTotalPrice().toString());
	}
	
	/**
	 * move to printer later
	 */
	public String toString() 
	{
		return "";
	}

	public TotalPrice getTotalPrice() {
		return totalPrice;
	}

	public LocalTime getSaleTime() {
		return saleTime;
	}

	public LocalDate getDate() {
		return date;
	}

	public Amount getTotalVAT() {
		return totalVAT;
	}

	public String getItemListAsString() {
		return itemListAsString;
	}
	
	public void setChange(Amount change) {
		this.change = change;
	}
	
	public Amount getChange() {
		return this.change;
	}
	
	public void setAmountPaid(Amount amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	public Amount getAmountPaid() {
		return this.amountPaid;
	}
	
	
}
