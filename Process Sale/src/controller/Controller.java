package controller;

import integration.CreateSystems;
import integration.DiscountSystem;
import integration.ExternalAccountingSystem;
import integration.ItemDescription;
import integration.ExternalInventorySystem;
import integration.Printer;
import integration.SaleLog;
import model.Amount;
import model.CashRegister;
import model.Change;
import model.PresentSaleDTO;
import model.Sale;
import model.SaleInformation;
import model.TotalPrice;

/**
 * 	This class is the application's only controller. All calls from the view
 *	passes through here.
 */
public class Controller {

	ExternalInventorySystem inventory;
	DiscountSystem discSys;
	ExternalAccountingSystem accounting;
	private SaleLog saleLog;
	
	Printer printer;
	CashRegister register;
	Sale sale;
	SaleInformation saleInfo;
	PresentSaleDTO displaySale;
	Change change;
	
	
	/**
	 * Creates an instance of the class
	 * @param systems
	 * @param printer
	 */
	public Controller(CreateSystems systems, Printer printer) {
		
		this.inventory = systems.getExternalInventorySystem();
		this.discSys = systems.getDiscountSystem();
		this.accounting = systems.getExternalAccountingSystem();
		this.saleLog = systems.getSaleLog();
		this.printer = printer;
		
		this.register = new CashRegister();
		
		//System.out.println("Controller created");
	}
	
	
	/**
	 * This method starts the sale
	 * 
	 */
	
	public void startSale() {
		this.sale = new Sale();
	}
	
	/**
	 * This method scans a particular item
	 * 
	 * @param itemID
	 * @param quantity
	 * @return current saleInfo, i.e latest scanned item and running total.
	 */
	public PresentSaleDTO findItem(int itemID, int quantity) {
/*
 * 	Debugging nullpointer
 * 	
	if(inventory!=null)
		System.out.println("inventory is not null");
	if(printer!=null)
		System.out.println("printer is not null");
	if(register!=null)
		System.out.println("register is not null");
	if(sale!=null)
		System.out.println("sale is not null");
*/	
	
		ItemDescription itemToBeAdded = inventory.findItem(itemID);
		if(itemToBeAdded!=null) {
			displaySale = this.sale.addItemToList(itemToBeAdded, quantity);
		}
	
		return displaySale;
	}
	
	
	/**
	 *  Comment comment, needs more comments
	 */
	public SaleInformation stopSale() {
		
		return this.saleInfo = sale.stopSale();
	}
	
	public TotalPrice checkDiscount(int customerID, SaleInformation saleInfo) {
		return discSys.checkDiscount(customerID, saleInfo);
	}
	/**
	 * 
	 * @param amountPaid
	 * @return
	 */
	public Amount enterAmountPaid(Amount amountPaid) {
		change = new Change(this.saleInfo);
		
		register.updateAmountStored(sale.getTotalPrice());
		updateSystems();
		
		change.calculateChange(amountPaid);
		
		saleInfo.setChange(change.getChange()); 
		saleInfo.setAmountPaid(amountPaid);
		
		printer.printReceipt(this.saleInfo);
		return change.getChange();
		
	}
	/**
	 * 	FIX CUSTOMER ID
	 */
	private void updateSystems() {
		inventory.updateInventory(saleInfo);
		accounting.updateAccounting(saleInfo);
		saleLog.storeSaleInformation(0, saleInfo);
		
	}

}
