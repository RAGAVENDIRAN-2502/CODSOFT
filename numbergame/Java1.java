package numbergame;

	import java.util.Scanner;

	public class Java1 {
		  public static void main(String[] args) {
		        Scanner scanner = new Scanner(System.in);

		        do {
		            System.out.println("Welcome to the Number Guessing Game!");

		            // Get user name
		            System.out.print("Enter your Nick name: ");
		            String userName = scanner.nextLine();
		            

		            if (userName.trim().isEmpty()) {
		                System.out.println("Invalid name. Please enter a valid name.");
		                continue;
		            }

		            int totalScore = 0;

		            do {
		            	int roundScore = 10 -playRound(userName);
		               
		                totalScore += roundScore;

		                System.out.println("Round Score: " + roundScore);
		                System.out.println("Total Score for " + userName + ": " + totalScore);

		                System.out.print("Do you want to play another round, " + userName + "? (yes/no): ");
		            } while (scanner.nextLine().equalsIgnoreCase("yes"));

		            System.out.print("Do you want to play again with a different user? (yes/no): ");
		        } while (scanner.nextLine().equalsIgnoreCase("yes"));

		        System.out.println("Thanks for playing the incredible game!");
		        scanner.close();
		    }

		    private static int playRound(String userName) {
		        // Generate a random number between 1 and 100
		        int secretNumber = (int) (Math.random() * 100) + 1;
		        int attempts = 0;
		        boolean guessedCorrectly = false;

		        System.out.println("You have 10 attempts to guess the number.");

		        while (attempts < 10 && !guessedCorrectly) {
		            try {
		                System.out.print("Attempt " + (attempts + 1) + ": Guess the number (between 1 and 100): ");
		                int guess = Integer.parseInt(new Scanner(System.in).nextLine());

		                if (guess < secretNumber) {
		                    System.out.println("small Number! Try again.");
		                } else if (guess > secretNumber) {
		                    System.out.println("Large Number! Try again.");
		                } else {
		                    System.out.println("Congratulations, " + userName + "! You guessed the correct number, " + secretNumber + "!");
		                    guessedCorrectly = true;
		                }

		                attempts++;
		            } catch (NumberFormatException e) {
		                System.out.println("Please enter a valid number.");
		            }
		        }

		        if (!guessedCorrectly) {
		            System.out.println("Sorry, " + userName + ", you've run out of attempts. The correct number was: " + secretNumber);
		        }

		        return 10 - attempts;
		    }
		}


	
