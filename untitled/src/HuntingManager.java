import java.util.Scanner;

public class HuntingManager {
    private static final int NOOB_ZOMBIE_CHOICE = 1;
    private static final int PRO_ZOMBIE_CHOICE = 2;
    private static final int RETURN_TO_MENU_CHOICE = 3;
    private static final int MIN_HIRE_MENU_OPTION = 1;
    private static final int MAX_HIRE_MENU_OPTION = 3;
    private static final int EXHAUSTION_DAMAGE = 10;

    private final Player player;
    private final PreyFactory preyFactory;
    private final ZombieFactory zombieFactory;
    private final MiniGameFactory miniGameFactory;
    private final Scanner scanner;

    public HuntingManager(Player player, PreyFactory preyFactory,
                          ZombieFactory zombieFactory, MiniGameFactory miniGameFactory,
                          Scanner scanner) {
        this.player = player;
        this.preyFactory = preyFactory;
        this.zombieFactory = zombieFactory;
        this.miniGameFactory = miniGameFactory;
        this.scanner = scanner;
    }

    public void huntAlone() {
        System.out.println("\n--- HUNTING ALONE ---");
        System.out.println("You venture out to find prey on your own...");

        Prey randomPrey = preyFactory.createRandomSimplePrey();
        System.out.println("You found a " + randomPrey.getName() + "!");
        System.out.println("Health rating: " + randomPrey.getHealthRating());
        System.out.println("Potential points: " + randomPrey.getPointValue());

        engageWithPrey(randomPrey);
    }

    public void hireZombies() {
        MenuManager menuManager = new MenuManager(scanner);
        menuManager.displayHireMenu();
        int choice = menuManager.getValidChoice(MIN_HIRE_MENU_OPTION, MAX_HIRE_MENU_OPTION);

        if (choice == RETURN_TO_MENU_CHOICE) {
            return;
        }

        HireableZombie scout = (choice == NOOB_ZOMBIE_CHOICE) ?
                zombieFactory.createZombie(Zombie.NOOB) :
                zombieFactory.createZombie(Zombie.PRO);

        if (player.getMoney() < scout.getHireCost()) {
            System.out.println("You don't have enough money to hire this zombie!");
            return;
        }

        player.decreaseMoney(scout.getHireCost());
        System.out.println("You hired a " + scout.getName() + " for " + scout.getHireCost() + " money.");

        Prey locatedPrey = scout.locatePrey(preyFactory);
        System.out.println("\nThe " + scout.getName() + " has located a " + locatedPrey.getName() + "!");
        System.out.println("Health rating: " + locatedPrey.getHealthRating());
        System.out.println("Potential points: " + locatedPrey.getPointValue());

        NavigationManager navigationManager = new NavigationManager(scanner);
        boolean navigationSuccessful = navigationManager.navigateToLocation(scout.getAccuracy());

        if (navigationSuccessful) {
            engageWithPrey(locatedPrey);
        } else {
            System.out.println("You failed to reach the prey. The hunt is unsuccessful.");
            player.decreaseHealth(EXHAUSTION_DAMAGE);
            System.out.println("You lost " + EXHAUSTION_DAMAGE + " health points from exhaustion.");
        }
    }

    private void engageWithPrey(Prey prey) {
        System.out.println("\n--- ENGAGING PREY ---");
        System.out.println("To consume the " + prey.getName() + ", you must win a mini-game!");

        MiniGame game = miniGameFactory.createRandomMiniGame();
        int score = game.play(scanner);

        System.out.println("Your score: " + score);
        System.out.println("Prey's health rating: " + prey.getHealthRating());

        if (score >= prey.getHealthRating()) {
            System.out.println("Success! You've defeated and consumed the " + prey.getName() + "!");
            player.increasePoints(prey.getPointValue());
            player.increaseMoney(prey.getMoneyValue());
            player.increaseHealth(prey.getHealthValue());

            System.out.println("You gained " + prey.getPointValue() + " points!");
            System.out.println("You gained " + prey.getMoneyValue() + " money!");
            System.out.println("You restored " + prey.getHealthValue() + " health!");
        } else {
            int damageTaken = prey.getHealthRating() - score;
            System.out.println("Failure! The " + prey.getName() + " escaped!");
            System.out.println("You took " + damageTaken + " damage from the encounter!");
            player.decreaseHealth(damageTaken);
        }
    }
}