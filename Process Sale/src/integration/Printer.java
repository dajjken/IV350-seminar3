package integration;

import model.DTO.Receipt;

/**
 *Represents a Printer that prints receipts. 
 *
 */
public class Printer {
	
	
	public Printer() {
	}
	
	/**
	 * Prints the String representation of <code>Receipt</code>
	 * @param receipt
	 */
	public void printReceipt(Receipt receipt) {

		System.out.println(receipt.toString());
	
	}
}
