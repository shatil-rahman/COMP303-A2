package a2;

/*
 * Filename: Checking.java
 * Developer: Shatil Rahman
 * Developer student id (lol): 260606042
 * Last modified: 9:00PM 1/19/2018 
 * Purpose: - Class for checking account.
 * 			- Contains methods specific to checking accounts, as opposed to savings accounts
 */

public class Checking extends Account {

	public Checking(int customerNo, int accountNo, float balance) {
		super(customerNo, accountNo, balance);
	
	}
	
	public boolean deposit(float amount) {
		/*
		 * Makes a deposit into the checking account
		 * Input: amount to be added, must be positive value or 0
		 * Returns: true if successful, false if failed
		 */
		float currentBalance = this.getBalance();
		
		if(amount <=0) {
			System.out.println("Amount to be deposited must be a positive number");
			return false;
		}
		else {
			if(this.setBalance(currentBalance + amount) == false) {
				return false;
			}
			else {
				System.out.println("Deposit successful, current balance is: " + this.getBalance());
				return true;
			}
		}
	}
	
	public boolean withdraw(float amount, float discountPercent) {
		/*
		 * Makes a withdrawal from the checking account
		 * Input: amount - amount to be withdrawn, must be positive number
		 * 		  discountPercent - withdrawal fee is discounted by this number
		 * 						  - must be a positive float between 0 and 1
		 * Returns: true if successful, false if failed
		 */
		float currentBalance = this.getBalance();
		float withdrawal_fee = (float)1.0 * discountPercent;
		
		if(amount <=0) {
			System.out.println("Amount to be withdrawn must be a positive number");
			return false;
		}
		else {
			if(this.setBalance(currentBalance - amount - withdrawal_fee) == false) {
				return false;
			}else {
				System.out.println("Withdrawal fee: " + withdrawal_fee);
				System.out.println("Withdrawal successful, current balance is: " + this.getBalance());
				return true;
			}
		}
		
	}

}
