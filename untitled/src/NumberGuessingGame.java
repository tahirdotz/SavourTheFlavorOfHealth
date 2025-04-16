import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame implements MiniGames {
    private final Random random = new Random();
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 7;

    @Override
    public int play(Scanner scanner) {
        System.out.println("--- NUMBER GUESSING GAME ---");
        System.out.println("Guess the number inorder to defeat this healthy beast " + MIN_NUMBER + " and " + MAX_NUMBER + ".");
        System.out.println("Try to guess it in " + MAX_ATTEMPTS + " attempts or less!");

        int secretNumber = random.nextInt(MAX_NUMBER) + MIN_NUMBER;
        int attempts = 0;
        boolean hasGuessed = false;

        while (attempts < MAX_ATTEMPTS && !hasGuessed) {
            System.out.print("Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + ": ");

            int guess;
            try {
                guess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            attempts++;

            if (guess < secretNumber) {
                System.out.println("Too low!");
            } else if (guess > secretNumber) {
                System.out.println("Too high!");
            } else {
                hasGuessed = true;
                System.out.println("Correct! You guessed it in " + attempts + " tries!");
            }
        }

        if (!hasGuessed) {
            System.out.println("Game over! The number was " + secretNumber + ".");
        }


        int score = hasGuessed ? 100 - ((attempts - 1) * 10) : 0;
        return Math.max(0, score);
    }
}