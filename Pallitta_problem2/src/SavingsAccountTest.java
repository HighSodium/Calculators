

public class SavingsAccountTest {

	public static void main(String[] args) {
		
		SavingsAccount saver1 = new SavingsAccount(2000.00);
		SavingsAccount saver2 = new SavingsAccount(3000.00);
		
		SavingsAccount.modifyInterestRate(0.04);
		
		System.out.print("========================= Interest rate = 4% =============================\n");
		System.out.printf("||  Savings Account 1:\t\t\t    Savings Account 2:\t\t||\n");
		for(int i=0; i < 12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			
			System.out.printf("||\tMonth %d: $%.2f \t\t\t Month %d: $%.2f\t||\n",i+1, saver1.getSavingsBalance(),i+1, saver2.getSavingsBalance());	
		}
		System.out.print("========================= Interest rate = 5% =============================\n");
		
		// yeah yeah dont repeat yourself but this was easier
		SavingsAccount.modifyInterestRate(0.05);
		System.out.printf("||  Savings Account 1:\t\t\t    Savings Account 2:\t\t||\n");
		for(int i=0; i < 12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			
			System.out.printf("||\tMonth %d: $%.2f \t\t\t Month %d: $%.2f\t||\n",i+1, saver1.getSavingsBalance(),i+1, saver2.getSavingsBalance());	
		}
		System.out.print("==========================================================================\n");
	}

}
