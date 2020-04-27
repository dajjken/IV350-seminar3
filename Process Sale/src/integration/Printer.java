package integration;

import model.DTO.Receipt;

public class Printer {
	
	
	public Printer() {
	}
	
	/**
	 * Prints the String representation of <code>Recept</code>
	 * @param receipt
	 */
	public void printReceipt(Receipt receipt) {

		System.out.println(receipt.toString());
	
	}
}
