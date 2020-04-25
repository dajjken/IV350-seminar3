package model;

public class TotalPrice {

	Amount amount;
	
	public TotalPrice() {
		this(new Amount(0));
		
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
	 */
	public String toString()
	{
		return amount.toString();
	}
}
