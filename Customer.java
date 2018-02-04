package a2;

/*
 * Filename: Customer.java
 * Developer: Shatil Rahman
 * Developer student id (lol): 260606042
 * Last modified: 9:00PM 1/19/2018 
 * Purpose: - Class for customer
 * 			- Contains methods for customer transactions
 */

import java.util.ArrayList;

public class Customer {
	
	private String name;
	private int customerNo;
	private float discountPercent;
	private ArrayList<Account> accounts;
	private int number_of_accounts;
	
	public Customer(String name, int customerNo, float discountPercent) {
		this.name = name;
		this.customerNo = customerNo;
		this.discountPercent = discountPercent;
		this.number_of_accounts = 0;
	}
	
	private boolean isValidAccountNo(int accountNo) {
		//Checks that accountNo is not negative and exists
		if(accountNo < 0) {
			System.out.println("Account Number cannot be negative");
			return false;
		}
		else if(this.accounts.get(accountNo) == null) {
			System.out.println("No accounts exist with this account number!");
			return false;
		}
		else return true;
	}
	
	public boolean createAccount(int type, float initialBalance) {
		/*
		 * Purpose: Creates the an account and adds it to the list of accounts owned by the customer
		 * 			The account no of the account is the index of the account in the ArrayList accounts
		 * Inputs: type - int, type of account to be created: 0 for Checking, 1 for Savings
		 * 		   initialBalance - initial balance of the new account, must be positive or 0
		 * 
		 * Returns: true if successful, false if failed
		 */
		if(type !=0 || type!=1) {
			System.out.println("type must be 0 or 1!");
			return false;
		}
		else if(initialBalance < 0) {
			System.out.println("Initial balance cannot be negative");
			return false;
			
		}
		else {
			if(type == 0) {  				//Checking account
				Checking acc = new Checking(this.customerNo, this.number_of_accounts, initialBalance);
				accounts.add(acc);
				
			}
			else {
				Savings acc = new Savings(this.customerNo,this.number_of_accounts,initialBalance);
				accounts.add(acc);
			}
			
			this.number_of_accounts++;
			return true;
			
		}
		

	}
	
	public boolean makeDeposit(int accountNo, float amount) {
		/*
		 * Purpose: makes a deposit into the specified account number,
		 * Inputs: accountNo - must be valid, and must exist
		 * 		   amount - amount to be deposited, this is checked for validation in the 
		 * 					account specific deposit methods
		 * Returns: true if successful, false if failed	
		 * 
		 */
		if(!this.isValidAccountNo(accountNo)) {
			return false;
		}
		else {
			Account acc = this.accounts.get(accountNo);//retrieves the account from the account list
			if(acc.getClass() == Checking.class) {//checks for actual type of the account
				return ((Checking) acc).deposit(amount);
			}
			else {
				return ((Savings) acc).deposit(amount, this.discountPercent);
			}
		}
	}
	
	public boolean makeWithdrawal(int accountNo, float amount) {
		/*
		 * Purpose: makes a withdrawal from the specified account number,
		 * Inputs: accountNo - must be valid, and must exist
		 * 		   amount - amount to be withdrawn, this is checked for validation in the 
		 * 					account specific withdraw methods
		 * Returns: true if successful, false if failed	
		 * 
		 */
		if(!this.isValidAccountNo(accountNo)) {
			return false;
		}
		else {
			Account acc = this.accounts.get(accountNo); //retrieves the account from the account list
			if(acc.getClass() == Checking.class) { //checks for actual type of the account
				return ((Checking) acc).withdraw(amount, this.discountPercent);
			}
			else {
				return ((Savings) acc).withdraw(amount);
			}
		}
	}
	
	public String getName() {
		//returns a copy of this customer's name
		String name = new String(this.name);
		return name;
	}
	
	
	public boolean makeTransfer(int from, int to, float amount) {
		/*
		 * Purpose: makes transfer from one account to another
		 * Inputs: from - account no of account from which amount is transferred,
		 * 				  must be valid, and must exist
		 * 		   to   - account no of account to which amount is transferred, 
		 * 			      must be valid and must exist
		 * 		 amount - amount to be withdrawn, this is checked for validation in the 
		 * 					setBalance methods
		 * Returns: true if successful, false if failed	
		 * 
		 */
		
		if(this.isValidAccountNo(from)) {
			Account accFrom = this.accounts.get(from);
			
		}
		
		
	}

}
