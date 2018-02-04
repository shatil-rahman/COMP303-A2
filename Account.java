package a2;

/*
 * Filename: Account.java
 * Developer: Shatil Rahman
 * Developer student id (lol): 260606042
 * Last modified: 9:00PM 1/19/2018 
 * Purpose: - Abstract class for account.
 * 			- Contains methods and fields common to both checking
 * 			  and saving acccounts, as well as common validation methods
 */

public abstract class Account {
	
	private float balance;
	private int customerNo;
	private int accountNo;
	
	public Account(int customerNo, int accountNo, float balance) {
		/*
		 * Constructor for abstract class account
		 * Inputs: customerNo - customer number of the customer object that this account belongs to
		 * 		   accountNo - accountNo, unique account number (for a customer), corresponds to index of customer's
		 * 					   arrayList of account objects
		 * 		   balance - initial balance of the newly created account
		 */
	
		this.accountNo = accountNo;
		this.customerNo = customerNo;
		this.balance = balance;

	}
	
	
	
	private static boolean isValidBalance(float balance) {
		//Checks that balance is not negative
		if(balance < 0) {
			System.out.println("Not a valid balance");
			return false;
		}
		else return true;
	}
	
	
	
	public int getCustomerNo() {
		//Returns the customer number
		return this.customerNo;
	}
	
	public int getAccountNo() {
		//Returns the account number
		return this.accountNo;
	}
	
	public float getBalance() {
		//Returns the balance
		return this.balance;
	}
	
	public boolean setBalance(float balance) {
		/*
		 * Sets the balance of the account
		 * Inputs: balance - float value to which should be set, should be positive or zero
		 * Returns: true if successful, false if invalid balance
		 */
		if(isValidBalance(balance)){
			this.balance = balance;
			return true;
		}else {
			return false;
		}
	}
	


}
