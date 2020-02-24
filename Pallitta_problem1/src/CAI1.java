import java.security.SecureRandom;
import java.util.Scanner;




public class CAI1 {

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
		System.out.println("Very good!");
		
	}
	
	/**
	 * List of incorrect messages to display
	 */
	public static void displayIncorrectMessage() {
		System.out.print("No! Please try again. : ");
		
	}

	
	
	
	
}
