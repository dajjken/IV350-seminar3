package model;

public class CashRegister {
	
	Amount storedAmount;
	
	public CashRegister() {
		storedAmount= new Amount(5000);
	}

	/**
	 * Updates the amount of cash stored in the register.
	 * @param cash represents the amount to be added
	 */
	public void updateAmountStored(Amount cash) {
		storedAmount = storedAmount.addAmounts(cash);
	}
	
	
}
