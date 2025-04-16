import java.util.Scanner;

public class MenuManager {
    private Scanner scanner;

    public MenuManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMainMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Hunt alone (Find random prey)");
        System.out.println("2. Hire zombies to scout for prey");
        System.out.println("3. Quit game");
        System.out.print("Enter your choice (1-3): ");
    }

    public void displayHireMenu() {
        System.out.println("\n--- HIRE ZOMBIES ---");
        System.out.println("Available zombie scouts:");
        System.out.println("1. Noob Zombie Scout (Cost: 10 | Accuracy: low)");
        System.out.println("2. Pro Zombie Scout (Cost: 40 | Accuracy: high)");
        System.out.println("3. Return to main menu");
        System.out.print("Choose a zombie to hire (1-3): ");
    }

    public int getValidChoice(int min, int max) {
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    valid = true;
                } else {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        return choice;
    }
}