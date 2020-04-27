package model.DTO;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import integration.ItemDescription;
import model.POS.Item;
import model.POS.Sale;
import model.util.Amount;
import model.util.TotalPrice;

public class SaleInformation {
	
	private ArrayList <Item> itemList = new ArrayList<>();
	private ItemDescription mostRecentScannedItem;
	LocalTime saleTime;
	LocalDate date;
	TotalPrice totalPrice;
	Amount totalVAT;
	Amount amountPaid = new Amount(0);
	Amount change = new Amount(0);
	String itemListAsString;
	
	public SaleInformation(Sale sale)
	{
		this.itemList = sale.getItemsInPurchase();
		this.saleTime = sale.getSaleTime();
		this.date = LocalDate.now();
		this.totalPrice = sale.getTotalPrice();
		this.totalVAT = sale.getTotalVAT();
		this.itemListAsString = sale.itemsToString(); 
	}
	
	public SaleInformation(SaleInformation saleInfo, Amount change, Amount amountPaid)
	{
		this.itemList = saleInfo.itemList;
		this.saleTime = saleInfo.saleTime;
		this.date = saleInfo.getDate();
		this.totalPrice = saleInfo.totalPrice;
		this.totalVAT = saleInfo.totalVAT;
		this.itemListAsString = saleInfo.itemListAsString;
		this.change = change;
		this.amountPaid = amountPaid;
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

	public Amount getTotalPriceAsAmount() {
		return totalPrice.getTotalPrice();
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
	
	public Amount getChange() {
		return this.change;
	}
	
	public Amount getAmountPaid() {
		return this.amountPaid;
	}
	
	
}
