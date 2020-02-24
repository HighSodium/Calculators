
public class SavingsAccount {

	private static double annualInterestRate;
	private double savingsBalance;
	
	//calculate monthly interest based on current savings balance
	// interest = (savings*interest) / 12
	// add to balance
	SavingsAccount(double balance){
		this.savingsBalance = balance;
	}
	//
	public void calculateMonthlyInterest() 
	{
		//calculate monthly interest
		double interest = (getSavingsBalance()*annualInterestRate) / 12;

		//set the new balance to be the current plus interest
		setSavingsBalance(getSavingsBalance() + interest);
		
	}

	static void modifyInterestRate(double rate) {
		annualInterestRate = rate;
		
	}
	
	public double getSavingsBalance() {
		return this.savingsBalance;
	}

	private void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	
}
