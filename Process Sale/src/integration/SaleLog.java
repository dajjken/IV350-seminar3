package integration;

import model.DTO.SaleInformation;

public class SaleLog {
	
	private SaleLog saleLog;
	
	public SaleLog() {
		//System.out.println("SaleLog created");
	}
	
	public SaleLog getSaleLog() {
		return saleLog;	
	}
	
	/**
	 * Stores the information about the sale in the sale log. Not implemented.
	 * @param CustomerID Represents a customer id-code.
	 * @param saleInfo Contains information about the sale.
	 */
	public void storeSaleInformation(int CustomerID, SaleInformation saleInfo) {
		//some code
	}

}
