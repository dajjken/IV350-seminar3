package model;

/**
 * This class represent the amount of money used in the program. 
 *
 */
public class Amount {
	
	private final double amount;
	
	
	/**
	 *  Creates an instance of this class with default constructor
	 */
	public Amount() {
		this(0);
	}
	
	/**
	 *  Creates an new instance of this class
	 * @param amount Represent the amount
	 */
	public Amount(double amount) {
		this.amount = amount;
	}
	/**
	 * Adds another amount to the current instance of this class.
	 * @param Represents the amount that will be added.
	 * @return the new updated amount
	 */
	public Amount addAmounts(Amount other) {
        return new Amount(this.amount + other.amount);
    }
	
	/**
	 * Subtracts the current instance from another amount-object.
	 * @param biggerAmount Represents the amount that will be subtracted from
	 * @return the new updated amount.
	 */
	public Amount subractCurrentAmount(Amount biggerAmount) {
        return new Amount(biggerAmount.amount - amount);
    }
	
	/**
	 * Multpliply the current instance with the parameter.
	 * @param number Represents the number of times the amount will be multiplied.
	 * @return the new updated amount
	 */
	public Amount multiplyAmount(int number) {
        return new Amount(amount * number);
    }
	
	/**
	 * Multpliply the current instance with the parameter.
	 * @param number Represents the number of times the amount will be multiplied.
	 * @return the new updated amount
	 */
	public Amount multiplyAmountDouble(double number) {
		System.out.println("MAD: " + amount);
        return new Amount(amount * number);
    }
	
	/**
	 * Returns the instance as a string-representation.
	 */
	public String toString()
	{
		return Double.toString(amount);
	}
}
