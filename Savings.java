package a2;

/*
 * Filename: Savings.java
 * Developer: Shatil Rahman
 * Developer student id (lol): 260606042
 * Last modified: 9:00PM 1/19/2018 
 * Purpose: - Class for savings account.
 * 			- Contains methods specific to savings accounts, as opposed to savings accounts
 */

public class Savings extends Account {

	public Savings(int customerNo, int accountNo, float balance) {
		super(customerNo, accountNo, balance);
		
	}
	
	public boolean deposit(float amount, float discountPercent) {
		/*
		 * Makes a deposit into the savings account
		 * Input: amount - amount to be added, must be positive value or 0
		 * 		  discountPercent - deposit bonus is increase by this percent
		 * 						  - must be a positive float between 0 and 1
		 * Returns: true if successful, false if failed
		 */
		float currentBalance = this.getBalance();
		float bonus = (float)1.0 * discountPercent;
		
		if(amount <=0) {
			System.out.println("Amount to be deposited must be a positive number");
			return false;
		}
		else {
			if(this.setBalance(currentBalance + amount + bonus) == false) {
				return false;
			}
			else {
				System.out.println("Bonus for deposit earned! Value: " + bonus );
				System.out.println("Deposit successful, current balance is: " + this.getBalance());
				return true;
			}
		}
	}
	
	public boolean withdraw(float amount) {
		/*
		 * Makes a withdrawal from the checking account
		 * Input: amount - amount to be withdrawn, must be positive number
		 * Returns: true if successful, false if failed
		 */
		float currentBalance = this.getBalance();
		
		if(amount <=0) {
			System.out.println("Amount to be withdrawn must be a positive number");
			return false;
		}
		else if(amount < 1000.0) {
			System.out.println("Must withdraw greater than or equal to $1000!");
			return false;
		}
		else {
			if(this.setBalance(currentBalance - amount) == false) {
				return false;
			}else {
				System.out.println("Withdrawal successful, current balance is: " + this.getBalance());
				return true;
			}
		}
		
	}

}
