package model;

import controller.Controller;

public class Change {
	
	private Amount amount;
	
	public Change(SaleInformation saleInfo)
	{
		this.amount = saleInfo.totalPrice.amount;
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
