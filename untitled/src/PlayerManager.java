import java.util.Scanner;

public class PlayerManager {
    private Player player;
    private Scanner scanner;

    public PlayerManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void setupPlayer() {
        System.out.println("\nWhat is your zombie name?");
        String name = scanner.nextLine();
        player = new Player(name, 100, 50, 15);

        System.out.println("\nWelcome " + name + "! You are a hungry zombie looking for the healthiest prey.");
        System.out.println("Your goal: Reach " + player.getTargetPoints() + " points before you run out of health or turns.");
    }

    public Player getPlayer() {
        return player;
    }

    public void displayStatus() {
        System.out.println("\n----------------------------");
        System.out.println("Health: " + player.getHealth());
        System.out.println("Money: " + player.getMoney());
        System.out.println("Points: " + player.getPoints() + "/" + player.getTargetPoints());
        System.out.println("Turns remaining: " + player.getRemainingTurns());
        System.out.println("----------------------------");
    }
}