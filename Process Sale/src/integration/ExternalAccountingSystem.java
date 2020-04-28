package integration;

import model.DTO.SaleInformation;

/**
 * This class represent an external accounting system at a retail store. The usage of
 * this class in not implemented except for calling dummy-method updateAccounting, which 
 * itself does nothing at this point. 
 *
 */
public class ExternalAccountingSystem {
	
	private ExternalAccountingSystem accounting;
	
	/**
	 * Create an instance.
	 */
	public ExternalAccountingSystem() {
	
	}
	
	/**
	 * Updates the accounting-system after completed <code>Sale</code>, not implemented.
	 * @param saleInfo Contains all info about the sale as <code>SaleInformation</code>-object.
	 */
	public void updateAccounting(SaleInformation saleInfo) {
		//some code
	}

}
