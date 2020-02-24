import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;



public class CAI5 {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Quiz();
		
	}

	//================= FUNCTIONS ===============================
	
	/**
	 * manages logic for quiz.
	 */
	public static void Quiz() 
	{	
		SecureRandom opRand = new SecureRandom();
		double questionAnswer, userAnswer, correctAns;
		int difficulty;
		int n1, n2, opIn, operator, max = 0;
		double score = 0;
		
		//quiz loop
		do {
			System.out.println("=================================================");
			difficulty = readDifficulty();
			if(difficulty > max) max = difficulty;
			
			operator = readProblemType();
			
			correctAns = 0;
			for(int i = 0; i < 10;i++) {
				
				//generate number based on difficulty and ask question
				if(operator == 5) {
					opIn = opRand.nextInt(4)+1;
				}else {
					opIn = operator;
				}
				
				//DIVIDE BY ZERO CHECK
				n1 = generateQuestionArgument(difficulty);
				do { 
					n2 = generateQuestionArgument(difficulty);
				}while(opIn == 4 && n2 == 0);
				//change to double
				
				questionAnswer = askQuestion(n1,n2,opIn);
				questionAnswer = Math.round(questionAnswer * 100.0) / 100.0;
				userAnswer = readResponse();
				userAnswer = Math.round(userAnswer * 100.0) / 100.0;
				
				//check if answer is correct and increment if it is
				if(isAnswerCorrect(questionAnswer, userAnswer)) {
					correctAns++;
				}	
			}
			score = correctAns/10f;
		}while(displayCompeletionMessage(score) == 'y');
		
		//============ end program
		if(max < 4) {
			System.out.println("\n\nYOU COWARD! YOU DIDN'T EVEN TRY LEVEL 4!\n\n");
		}else {
			System.out.println("\n\nGoodbye! :)");
		}
	}
	
	/**
	 * Have the user determine their own difficulty
	 * @return (int) choice - Difficulty 1-4
	 */
	public static int readDifficulty() {
		System.out.println("Which difficulty do you want to start on?");
		System.out.println("--> Level 1: numbers up to 9.");
		System.out.println("--> Level 2: numbers up to 99.");
		System.out.println("--> Level 3: numbers up to 999.");
		System.out.println("--> Level 4: numbers up to 9999.");
		System.out.print("Enter level: ");
		
		int choice = scan.nextInt();
		while(choice < 1 || choice > 4) {
			System.out.print("\nYou cannot handle that level yet!  Please pick 1-4: ");
			choice = scan.nextInt();
		}
		return choice;
	}
	
	public static int readProblemType() {
		System.out.println("\nWhich math operator do you want to use?");
		System.out.println("--> 1: Addition.");
		System.out.println("--> 2: Mulitplication.");
		System.out.println("--> 3: Subtraction.");
		System.out.println("--> 4: Division.");
		System.out.println("--> 5: ALL OF THEM CAUSE I'M A BEAST!!");
		System.out.print("Enter operation: ");
		
		
		
		int choice = scan.nextInt();
		while(choice < 1 || choice > 5) {
			System.out.print("\nThat operation does not exist!  Please pick 1-5: ");
			choice = scan.nextInt();
		}
		System.out.println();//space
		return choice;
	}
	
	/**
	 * Generates a random number 0 - X based on input level.
	 * @param level - level of difficulty
	 * @return (int) n - random gen'd number based on level input
	 */
	static int generateQuestionArgument(int level){
		SecureRandom random = new SecureRandom();
		int n = 0;
		
		switch(level) {
		case 1:
			n = random.nextInt(9);
			break;	
			
		case 2:
			n = random.nextInt(99);
			break;	
			
		case 3:
			n = random.nextInt(999);
			break;	
			
		case 4:
			n = random.nextInt(9999);
			break;
		}
		return n;
		
	}
	
	/**
	 * Asks user a math related question.
	 * @return Answer to question asked.
	 */
	public static double askQuestion(int A, int B, int operator) {
			double n = 0;
		
		switch(operator) {
		case 1:
			System.out.printf("How much is %d plus %d?: ", A, B);
			n = (double)A + B;
			break;	
			
		case 2:
			System.out.printf("How much is %d times %d?: ", A, B);
			n = (double)A * B;
			break;	
	
		case 3:
			System.out.printf("How much is %d minus %d?: ", A, B);
			n = (double)A - B;
			break;	
			
		case 4:
			System.out.printf("\nHow much is %d divided by %d (rounded to two decimal points)?: ", A, B);
			n = (double)A / B;
			break;
		}
		return n;
		
	}
	
	/**
	 * Gets user input.
	 * @return User input.
	 */
	public static double readResponse()
	{
		return scan.nextDouble();
	}

	/**
	 * Checks to see if the users response 
	 * equals the question asked.
	 * @param questionAnswer - the correct answer
	 * @param userAnswer - the users response
	 * @return TRUE if the answers match.
	 * FALSE if they do not.
	 */
	public static boolean isAnswerCorrect(double questionAnswer,double userAnswer) 
	{
		boolean isCorrect = (questionAnswer == userAnswer);
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
