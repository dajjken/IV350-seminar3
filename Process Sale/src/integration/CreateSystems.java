package integration;

public class CreateSystems {
	
	//CreateSystems systems;
	private ExternalInventorySystem inventory;
	private ExternalAccountingSystem accounting;
	private SaleLog saleLog;
	private DiscountSystem discSys;
	
	/**
	 *  NEED EDITING   NULLPOINTER TO FIELDS
	 */
	public CreateSystems()
	{
		this.inventory = new ExternalInventorySystem();
		accounting = new ExternalAccountingSystem();
		saleLog = new SaleLog();
		discSys = new DiscountSystem();
		
	//	System.out.println("All systems created");
	}


	public ExternalInventorySystem getExternalInventorySystem() {
		return inventory;
	}


	public ExternalAccountingSystem getExternalAccountingSystem() {
		return accounting;
	}


	public SaleLog getSaleLog() {
		return saleLog;
	}


	public DiscountSystem getDiscountSystem() {
		return discSys;
	}

}
