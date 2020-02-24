import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;


public class CAI2 {

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
		int questionAnswer, userAnswer;

		questionAnswer = askQuestion();
		do {
			userAnswer = readResponse();
		}while(isAnswerCorrect(questionAnswer, userAnswer) == false);
		
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
			System.out.print("No! Please try again. : ");
			break;
		case 2:
			System.out.print("Wrong! Try once more. : ");
			break;
		case 3:
			System.out.print("Dont give up! : ");
			break;
		case 4:
			System.out.print("No! Keep trying. : ");
			break;
		}
	}

	
	
	
	
}
