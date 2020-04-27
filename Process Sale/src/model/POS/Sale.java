package model.POS;

import java.time.LocalTime;
import java.util.ArrayList;

import integration.ItemDescription;
import model.DTO.PresentSaleDTO;
import model.DTO.SaleInformation;
import model.util.Amount;
import model.util.TotalPrice;

/**
 * This class represents a purchase of goods made by a single customer.
 * 
 */
public class Sale {
	
	LocalTime saleTime;
	ArrayList<Item> itemsInPurchase = new ArrayList<>();
	TotalPrice totalPrice;
	Amount totalPriceWithVAT;
	
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
		updateTotalPriceAndVAT(newItem, quantity);
		
		Item recentItem =getMostRecentItem(newItem);
		
		return new PresentSaleDTO(recentItem, totalPrice);
	}

	private void updateTotalPriceAndVAT(ItemDescription item, int quantity) {
		Amount priceOfItem = calculatePriceOfItem(item, quantity);
		
		totalPrice.addToTotalPrice(priceOfItem);
		Amount VAT = calulateVAT(item.getVATRate(), priceOfItem);
		totalPrice.addToTotalVAT(VAT);
		
	}
	
	private Amount calulateVAT (double VATrate, Amount price) {
		return price.multiplyAmountDouble(VATrate);
	}
	
	private Amount calculatePriceOfItem(ItemDescription item, int quantity) {
		return item.getPrice().multiplyAmount(quantity);
	}
	
	private void updateList(ItemDescription itemToBeChecked, int quantity) {
		if(this.itemIsInList(itemToBeChecked)) {
			for(Item item: itemsInPurchase) {
				if(item.itemDesc.equalID(itemToBeChecked)) {
					item.updateQuantity(quantity);
				}
			}
		}	
		else {
			itemsInPurchase.add(new Item(itemToBeChecked, quantity));
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
	
	private Item getMostRecentItem(ItemDescription itemDescription) {
		int index = getIndexOfItemInList(itemDescription);
		System.out.println("index is: " + index);
		Item newItem = itemsInPurchase.get(index);
		System.out.println("item is:"+newItem.itemDesc.getName());
		return newItem;
	}
	
	private int getIndexOfItemInList(ItemDescription itemDesc) {
		int index = -1;
		for(Item item: itemsInPurchase) {
			if(itemIsInList(itemDesc)) {
			index= itemsInPurchase.indexOf(item);
			System.out.println("inside getIndex: index is" + index);
			break;
			}
		}

		return index;
	}
	
	/**
	 * 
	 */
	public SaleInformation stopSale() {
		SaleInformation saleInfo = new SaleInformation(this);
		return saleInfo;
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
	public TotalPrice getTotalPrice() {
		return totalPrice;
	}

	public LocalTime getSaleTime() {
		return saleTime;
	}

	public ArrayList<Item> getItemsInPurchase() {
		return itemsInPurchase;
	}

	public Amount getTotalVAT() {
		return totalPrice.getTotalVAT();
	}

	public Amount getTotalPriceWithVAT() {
		return totalPriceWithVAT;
	}
	
}

