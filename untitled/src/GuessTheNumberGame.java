import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame implements Minigames {

    @Override
    public int playGame() {
        int numberToDisplay = generateRandomNumber();
        System.out.println("Remember this number: " + numberToDisplay);

        try {
            Thread.sleep(300);
            TerminalUtilForGuessTheNumber.clearTerminal();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

        return askForGuess(numberToDisplay);
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }

    private int askForGuess(int correctNumber) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What was the number? ");
        int userGuess = scanner.nextInt();

        if (userGuess == correctNumber) {
            System.out.println("Correct! ");
            return 1;
        } else {
            System.out.println("Oops! The correct number was " + correctNumber);
            return 0;
        }
    }
}
