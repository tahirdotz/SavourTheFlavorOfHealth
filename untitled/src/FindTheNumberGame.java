import java.util.Scanner;

public class FindTheNumberGame implements MiniGames {
    private static final int MIN_DIGITS = 6;
    private static final int MAX_DIGITS = 8;
    private static final int DISPLAY_TIME_MS = 500; // 0.5 seconds
    private static final int MAX_ATTEMPTS = 3;

    public FindTheNumberGame(Timer timer) {
    }

    @Override
    public int play(Scanner scanner) {
        System.out.println("\n--- NUMBER MEMORY CHALLENGE ---");
        System.out.println("Memorize the number that will appear briefly!");
        System.out.println("You'll have " + MAX_ATTEMPTS + " attempts to guess it correctly.");


        int digitCount = MIN_DIGITS + (int)(Math.random() * (MAX_DIGITS - MIN_DIGITS + 1));
        double minNumber =  Math.pow(10, digitCount - 1);
        double maxNumber =  Math.pow(10, digitCount) - 1;
        double targetNumber = minNumber +(Math.random() * (maxNumber - minNumber + 1));

        System.out.println("The number will appear for 0.5 seconds...");
        System.out.println("Ready? Press Enter to continue!");
        scanner.nextLine();

        System.out.println("\nNumber: " + targetNumber);
        try {
            Thread.sleep(DISPLAY_TIME_MS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TerminalUtilForGuessTheNumber.clearTerminal();

        System.out.println("What was the number?");
        System.out.println("(It was a " + digitCount + "-digit number)");

        int attempts = 0;
        boolean guessedCorrectly = false;

        while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
            System.out.print("Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + ": ");

            long userGuess;
            try {
                userGuess = Long.parseLong(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            attempts++;

            if (userGuess == targetNumber) {
                System.out.println("Correct! You have an excellent memory!");
                guessedCorrectly = true;
            } else {
                System.out.println("Incorrect!");
                if (attempts < MAX_ATTEMPTS) {
                    System.out.println("Try again!");
                }
            }
        }

        if (!guessedCorrectly) {
            System.out.println("Sorry! The correct number was: " + targetNumber);
        }
        int score = guessedCorrectly ? 100 - ((attempts - 1) * 30) : 0;
        return Math.max(0, score);
    }
}