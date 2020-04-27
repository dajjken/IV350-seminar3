package integration;

import model.DTO.SaleInformation;
import model.util.TotalPrice;

public class DiscountSystem {
	
	TotalPrice newTotalPrice;
	
	public DiscountSystem() {
		//System.out.println("Discount created");
	}

	public DiscountSystem getDiscountSystem() {
		return this;
	}

	/**
	 * Checks if the customer is egible for discount, since discount is not 
	 * applied to this task, will always return the same totalprice.
	 * @param customerID Represent the unique id for a customer
	 * @param saleInfo Contains all sale information
	 * @return The same totalprice 
	 */
	public TotalPrice checkDiscount(int customerID, SaleInformation saleInfo) {
		if(true)
		{
			System.out.println("Not egible for discount");
			return saleInfo.getTotalPrice();
		}
		else
			return newTotalPrice;
	}
	
}
