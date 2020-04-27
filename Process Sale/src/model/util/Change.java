package model.util;

import model.DTO.SaleInformation;

public class Change {
	
	private Amount amount;
	
	public Change(SaleInformation saleInfo)
	{
		this.amount = saleInfo.getTotalPrice().addPriceAndVAT();
	}

	/**
	 *  Updates the change 
	 * @param paidAmount
	 */
	public void calculateChange(Amount paidAmount) 
	{
	this.amount = amount.subractCurrentAmount(paidAmount);
	
	}
	
	public Amount getChange() {
		return amount;
	}
}
