package model.util;

public class TotalPrice {

	Amount amount;
	Amount totalVAT;
	
	public TotalPrice() {
		this.amount = new Amount(0);
		this.totalVAT = new Amount(0);
		
	}
	
	public TotalPrice(Amount newAmount)
	{
		this.amount = newAmount;
	}
	
	/**
	 * Adds a amount to the current totalprice.
	 * @param newAmount	represents the amount to be added.
	 */
	public void addToTotalPrice(Amount newAmount) {
		this.amount = this.amount.addAmounts(newAmount);
		
	}
	/**
	 * 
	 * @param number
	 */
	public void addToTotalVAT(Amount number) {
		
		this.totalVAT = this.totalVAT.addAmounts(number);
		
	}
	
	/**
	 * 
	 * @return
	 */
	public Amount addPriceAndVAT() {
		return this.amount.addAmounts(totalVAT);
	}
	
	public Amount getTotalPrice() {
		return amount;
	}
	
	public Amount getTotalVAT() {
		return totalVAT;
	}

	/**
	 * 
	 */
	public String toString()
	{
		return amount.toString();
	}
}
