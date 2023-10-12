import java.util.Scanner;

public class NumberGuessingGame {

    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 100;
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Generate a random number
        int randomNumber = (int) (Math.random() * (MAX_RANGE - MIN_RANGE + 1)) + MIN_RANGE;

        // Start the game loop
        int attemptsRemaining = MAX_ATTEMPTS;
        while (true) {
            // Prompt the user to enter their guess
            System.out.println("Guess a number between " + MIN_RANGE + " and " + MAX_RANGE + ": ");
            int userGuess = scanner.nextInt();

            // Compare the user's guess with the generated number
            if (userGuess == randomNumber) {
                // The user guessed correctly
                System.out.println("Correct! You guessed the number in " + attemptsRemaining + " attempts.");
                break;
            } else if (userGuess > randomNumber) {
                // The user's guess is too high
                System.out.println("Too high. Try again.");
            } else {
                // The user's guess is too low
                System.out.println("Too low. Try again.");
            }

            // Reduce the number of attempts remaining
            attemptsRemaining--;

            // If the user has no more attempts remaining, end the game
            if (attemptsRemaining == 0) {
                System.out.println("You ran out of attempts. The correct number was " + randomNumber + ".");
                break;
            }
        }

        // Ask the user if they want to play again
        System.out.println("Do you want to play again? (y/n) ");
        String playAgain = scanner.next();

        if (playAgain.equalsIgnoreCase("y")) {
            // Start a new round of the game
            main(args);
        }

        // Calculate the user's score
        int score = 0;
        if (attemptsRemaining > 0) {
            score = attemptsRemaining;
        } else {
            score = -1; // To indicate that the user lost
        }

        // Display the user's score
        System.out.println("Your score is: " + score);

        // Close the scanner
        scanner.close();
    }
}
