import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class CAI3 {

	static Scanner scan = new Scanner(System.in);
	
	public static void b_main(String[] args) {
		
		Quiz();
		
	}

	//================= FUNCTIONS ===============================
	
	/**
	 * manages logic for quiz.
	 */
	public static void Quiz() 
	{	
		int questionAnswer, userAnswer, correctAns;
		double score = 0;
		
		//quiz loop
		do {
			correctAns = 0;
			for(int i = 0; i < 10;i++) {
				questionAnswer = askQuestion();
				userAnswer = readResponse();
				
				//check if answer is correct and increment if it is
				if(isAnswerCorrect(questionAnswer, userAnswer)) {
					correctAns++;
				}	
			}
			score = correctAns/10f;
		}while(displayCompeletionMessage(score) == 'y');
		//
	}
	
	/**
	 * Asks user a math related question.
	 * @return Answer to question asked.
	 */
	public static int askQuestion() {
		SecureRandom random = new SecureRandom();
		int A = random.nextInt(10);
		int B = random.nextInt(10);
		
		System.out.printf("How much is %d times %d?: ", A, B);
		
		return (A * B);
		
	}
	
	/**
	 * Gets user input.
	 * @return User input.
	 */
	public static int readResponse()
	{
		return scan.nextInt();
	}

	/**
	 * Checks to see if the users response 
	 * equals the question asked.
	 * @param answer - the correct answer
	 * @param response - the users response
	 * @return TRUE if the answers match.
	 * FALSE if they do not.
	 */
	public static boolean isAnswerCorrect(int answer,int response) 
	{
		boolean isCorrect = (answer == response);
		if(isCorrect) {
			displayCorrectMessage();
		}else {
			displayIncorrectMessage();
		}	
		return isCorrect;
		
	}
	
	/**
	 * List of correct messages to display
	 */
	public static void displayCorrectMessage() {
		Random rand = new Random();
		int pick = rand.nextInt(4) + 1;
		
		switch(pick) {
		case 1:
			System.out.println("\nVery good!");
			break;
		case 2:
			System.out.println("\nExcellent!");
			break;
		case 3:
			System.out.println("\nNice work!");
			break;
		case 4:
			System.out.println("\nKeep up the good work!");
			break;
		}	
	}
	
	/**
	 * List of incorrect messages to display
	 */
	public static void displayIncorrectMessage() {
		Random rand = new Random();
		int pick = rand.nextInt(4) + 1;
		
		switch(pick) {
		case 1:
			System.out.print("\nNo! Please try again.\n");
			break;
		case 2:
			System.out.print("\nWrong! Try once more.\n");
			break;
		case 3:
			System.out.print("\nDont give up!\n");
			break;
		case 4:
			System.out.print("\nNo! Keep trying.\n");
			break;
		}
	}

	/**
	 * Displays user score and a message based on the percentage of incorrect answers
	 * @param  score (double) - the users end score as a double (0.xxxx)
	 * @return (bool) if the user wants to continue
	 */
	public static char displayCompeletionMessage(double score) {
		System.out.printf("\n++++++++++++++++++++++++");
		System.out.printf("\nYour Score: %.0f%%",score*100);
		System.out.printf("\n++++++++++++++++++++++++\n\n");

		
		if(score >= 0.75) {
			System.out.println("Congratulations, you are ready to GO TO THE NEXT LEVEL!");
		}
		else {
			System.out.println("Please ask your teacher for extra help.");
		}
		
		System.out.print("\nWould you like to try a new set? (y for Yes // n for No): ");
		
		char select = scan.next().toLowerCase().charAt(0);
		while(select != 'y' && select != 'n') {
			System.out.print("\nPlease select 'y' for yes or 'n' for no.: ");
			select = scan.next().toLowerCase().charAt(0);
		}
		return select;
	}
	

}
