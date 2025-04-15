import java.util.Random;
import java.util.Scanner;

public class NavigationManager {
    private Scanner scanner;
    private Random random;

    public NavigationManager(Scanner scanner) {
        this.scanner = scanner;
        this.random = new Random();
    }

    public boolean navigateToLocation(double accuracy) {
        System.out.println("\n--- NAVIGATION ---");
        System.out.println("You need to follow directions to find your prey...");

        String[] directions = {"north", "south", "east", "west"};
        int steps = 2 + random.nextInt(2);

        for (int i = 0; i < steps; i++) {
            boolean accurateDirection = random.nextDouble() <= accuracy;
            String correctDirection = directions[random.nextInt(directions.length)];

            if (accuracy < 0.5) {
                String wrongDirection;
                do {
                    wrongDirection = directions[random.nextInt(directions.length)];
                } while (wrongDirection.equals(correctDirection));

                System.out.println("The confused zombie hesitates and says: \"I think it's " +
                        correctDirection + "... or maybe " + wrongDirection + "?\"");
            } else {
                String givenDirection = accurateDirection ? correctDirection :
                        directions[(random.nextInt(directions.length - 1) + 1) % directions.length];
                System.out.println("The zombie tells you to go: " + givenDirection);
            }

            System.out.print("Enter the direction you want to go: ");
            String playerInput = scanner.nextLine().trim().toLowerCase();

            if (!isDirectionCorrect(playerInput, correctDirection, accurateDirection)) {
                return false;
            }
        }
        System.out.println("You successfully navigated to the prey's location!");
        return true;
    }

    private boolean isDirectionCorrect(String playerInput, String correctDirection, boolean accurateDirection) {
        if (accurateDirection) {
            return playerInput.equals(correctDirection);
        } else {
            return playerInput.equals(correctDirection);
        }
    }
}