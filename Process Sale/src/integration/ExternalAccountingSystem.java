package integration;

import model.SaleInformation;

public class ExternalAccountingSystem {
	
	private ExternalAccountingSystem accounting;
	
	public ExternalAccountingSystem() {
		//System.out.println("accounting created");
	}
	
	public ExternalAccountingSystem getExternalAccountingSystem()
	{
		return accounting;
	}
	
	/**
	 * Updates the accounting-system after completed sale, not implemented.
	 * @param saleInfo Contains all info about the completed sale.
	 */
	public void updateAccounting(SaleInformation saleInfo) {
		//some code
	}

}
