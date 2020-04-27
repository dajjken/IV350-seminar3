package controller;

import integration.CreateSystems;
import integration.DiscountSystem;
import integration.ExternalAccountingSystem;
import integration.ItemDescription;
import integration.ExternalInventorySystem;
import integration.Printer;
import integration.SaleLog;
import model.DTO.PresentSaleDTO;
import model.DTO.Receipt;
import model.DTO.SaleInformation;
import model.POS.CashRegister;
import model.POS.Sale;
import model.util.Amount;
import model.util.Change;
import model.util.TotalPrice;

/**
 * 	This class is the application's only controller. All calls from the view
 *	passes through here.
 */
public class Controller {

	private ExternalInventorySystem inventory;
	private DiscountSystem discSys;
	private ExternalAccountingSystem accounting;
	private SaleLog saleLog;
	
	private Printer printer;
	private CashRegister register;
	private Sale sale;
	private SaleInformation saleInfo;
	
//	private Change change;
	
	
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

		PresentSaleDTO displaySale = null;
	
		ItemDescription itemToBeAdded = inventory.findItem(itemID);
		if(itemToBeAdded!=null) {
			displaySale = this.sale.addItemToList(itemToBeAdded, quantity);
		}
	
		return displaySale;
	}
	
	
	/**
	 * Stops the sale.
	 * @return Information about the sale as an SaleInformation-object. 
	 */
	public SaleInformation stopSale() {
		
		return this.saleInfo = sale.stopSale();
	}
	
	/**
	 *  Check if the customer is egible for discount. Not applied to this task, will 
	 *  return the same total price stored in saleInfo. 
	 * @param customerID Represents the unique id for the customer.
	 * @param saleInfo Contains information about the sale
	 * @return The same total price as in the SaleInformation object.
	 */
	public TotalPrice checkDiscount(int customerID, SaleInformation saleInfo) {
		return discSys.checkDiscount(customerID, saleInfo);
	}
	
	/**
	 *  
	 * @param amountPaid
	 * @return
	 */
	public void enterAmountPaid(Amount amountPaid) {
		Change change = new Change(this.saleInfo);
		
		register.updateAmountStored(saleInfo.getTotalPriceAsAmount());
		change.calculateChange(amountPaid);
		createFinalSaleInformation(change.getChange(), amountPaid);
		
		updateSystems();
		
		printReceipt();
		
	}
	/**
	 * 	FIX CUSTOMER ID
	 */
	private void updateSystems() {
		inventory.updateInventory(saleInfo);
		accounting.updateAccounting(saleInfo);
		saleLog.storeSaleInformation(0, saleInfo);
		
	}
	
	/**
	 * 
	 * @param change
	 * @param amountPaid
	 */
	private void createFinalSaleInformation(Amount change, Amount amountPaid) {
		saleInfo = new SaleInformation(this.saleInfo, change, amountPaid);
	}
	
	private void printReceipt() {
		printer.printReceipt(new Receipt(this.saleInfo));
	}
	

}
