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
	//Amount totalPriceWithVAT;
	
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
	 * Adds a <code>Item</code> to the <code>ArrayList</code> of goods to be purchased. Updates the
	 * <code>TotalPrice</code> and returns the most recent scanned item and some information about the 
	 * sale as a <code>PresentSaleDTO</code>-object.
	 * 
	 * @param newItem The <code></code>ItemDescription of the <code>Item</code> to be added
	 * @param quantity Number of items to be added
	 */
	public PresentSaleDTO addItemToList(ItemDescription newItem, int quantity) {
		updateList(newItem, quantity);
		updateTotalPriceAndVAT(newItem, quantity);
		
		Item recentItem = getMostRecentItem(newItem);
		
		return new PresentSaleDTO(recentItem, totalPrice);
	}

	/**
	 * Updates the <code>ArrayList</code> of items with a new Item. If the <code></code>Item is already
	 * in the list, then the quantity of that item increases.
	 * 
	 * @param itemToBeChecked Is the the <code>ItemDescription</code> of the item to be added.
	 * @param quantity The quantity of the item.
	 */
	private void updateList(ItemDescription itemToBeChecked, int quantity) {
		if(this.itemIsInList(itemToBeChecked)) {
			for(Item item: itemsInPurchase) {
				if(item.itemDesc.equalID(itemToBeChecked)) {
					item.updateQuantity(quantity);
					break;
				}
			}
		}	
		else {
			itemsInPurchase.add(new Item(itemToBeChecked, quantity));
		}		
	}
	
	
	private void updateTotalPriceAndVAT(ItemDescription item, int quantity) {
		Amount priceOfItem = calculatePriceOfItem(item, quantity);
		Amount VAT = calulateVAT(item.getVATRate(), priceOfItem);
	
		totalPrice.addToTotalPrice(priceOfItem);
		totalPrice.addToTotalVAT(VAT);
		
	}
	
	private Amount calulateVAT (double VATrate, Amount price) {
		return price.multiplyAmountDouble(VATrate);
	}
	
	private Amount calculatePriceOfItem(ItemDescription item, int quantity) {
		return item.getPrice().multiplyAmount(quantity);
	}
	
	
	
	/**
	 * Checks if the <code>ArrayList</code> of items contains an <code>Item</code> with a
	 * matching ID as the parameter <code>ItemDescription</code>.
	 * 
	 * @param checkedItem Represent the description of the item to be checked.
	 * @return <code>True</code> if the list contains a matching item, else <code>False</code>.
	 */
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
	 * Returns the most recent scanned item.
	 * @param itemDescription <code>ItemDescription</code> of the most recent scanned item.
	 * @return The <code>Item</code> searched after.
	 */
	private Item getMostRecentItem(ItemDescription itemDescription) {
		int index = getIndexOfItemInList(itemDescription);
		Item newItem = itemsInPurchase.get(index);
		return newItem;
	}
	
	/**
	 * Searches the list of items for a specified item. If a matching item is found, 
	 * the index of that item is returned. If not, -1 is returned.
	 * @param itemDesc <code>ItemDescription</code> of the item searched for.
	 * @return The index of the searched item if found, else -1.
	 */
	private int getIndexOfItemInList(ItemDescription itemDesc) {
		int index = -1;
		for(Item item: itemsInPurchase) {
			if(item.itemDesc.equalID(itemDesc)) {
				index= itemsInPurchase.indexOf(item);
			}
		}
		return index;
	}

	/**
	 * Stops the sale and returns the first <code>SaleInformation</code>.
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
	 * Returns the <code>TotalPrice</code> that contains the total price and VAT-total.
	 * @return The total price of the current <code>Sale</code>.
	 */
	public TotalPrice getTotalPrice() {
		return totalPrice;
	}

	/**
	 * Returns the time when the <code>Sale</code> started.
	 * @return saleTime as a <code>LocalTime</code>-object.
	 */
	public LocalTime getSaleTime() {
		return saleTime;
	}

	/**
	 * Returns the <code>ArrayList</code>.
	 * @return The list of all items. 
	 */
	public ArrayList<Item> getItemsInPurchase() {
		System.out.println("Ewhen is this used?");
		return itemsInPurchase;
	}
	
}

