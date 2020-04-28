package model.DTO;

/**
 * The class represents the receipt that will be printed.
 *
 */
public class Receipt {

	private SaleInformation saleInfo;
	
	/**
	 * Creates a new instance by using the <code>SaleInformation</code>.
	 * @param saleInfo contains information about the <code>Sale</code>.
	 */
	public Receipt(SaleInformation saleInfo) {
		this.saleInfo = saleInfo;
	}
	
	/**
	 * Returns the String-representation of this instance. Will be used when 
	 * printing the receipt.  
	 */
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("-------Receipt-------\n");
		sb.append(saleInfo.getItemListAsString());
		sb.append("---------------------\n");
		sb.append("VAT: " + saleInfo.getTotalVAT());
		sb.append("\nTotal Price:\n"+saleInfo.getTotalPrice().getFinalPrice());
		sb.append("\nAmount paid: "+saleInfo.getAmountPaid());
		sb.append("\nChange: "+ saleInfo.getChange());
		sb.append("\n---------------------");
		sb.append("\nTime of sale:\n");
		sb.append(getHourAndMinute()+"\n");
		sb.append("Date:\n");
		sb.append(saleInfo.getDate()+"\n");
		sb.append("---------------------\n");
		sb.append("Thank you for shopping\n@ FAKE STORE™");
		
		return sb.toString();
		
	}
	
	private String getHourAndMinute() {
		return saleInfo.getSaleTime().getHour()+":"+saleInfo.getSaleTime().getMinute();
	}
	
}
