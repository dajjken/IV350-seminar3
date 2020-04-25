package integration;

import model.SaleInformation;

public class Printer {
	
	
	public Printer() {
	}
	
	
	public void printReceipt(SaleInformation saleInfo) {

		StringBuilder sb = new StringBuilder();
		sb.append("-------Receipt-------\n");
		sb.append(saleInfo.getItemListAsString());
		sb.append("---------------------\n");
		sb.append("Total Price:\n"+saleInfo.getTotalPrice().toString());
		sb.append("\nAmount paid: "+saleInfo.getAmountPaid());
		sb.append("\nChange: "+ saleInfo.getChange());
		sb.append("\n---------------------");
		sb.append("\nTime of sale:\n");
		sb.append(saleInfo.getSaleTime()+"\n");
		sb.append("Date:\n");
		sb.append(saleInfo.getDate()+"\n");
		sb.append("---------------------\n");
		System.out.println(sb.toString()); 
	
	}
}
