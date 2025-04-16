import java.util.Scanner;

public class GameEngine {
    private static GameEngine instance;
    private final Scanner scanner;
    private final PreyFactory preyFactory;
    private final ZombieFactory zombieFactory;
    private final MiniGameFactory miniGameFactory;
    private PlayerManager playerManager;
    private GameStateManager gameStateManager;
    private HuntingManager huntingManager;
    private MenuManager menuManager;

    private GameEngine() {
        scanner = new Scanner(System.in);
        preyFactory = new PreyFactory();
        zombieFactory = new ZombieFactory();
        miniGameFactory = new MiniGameFactory();
    }

    public static GameEngine getInstance() {
        if (instance == null) {
            instance = new GameEngine();
        }
        return instance;
    }

    public void startGame() {
        System.out.println("================================");
        System.out.println("SAVOUR THE FLAVOR OF HEALTH");
        System.out.println("A Post-Apocalyptic Zombie Game");
        System.out.println("================================");

        playerManager = new PlayerManager(scanner);
        playerManager.setupPlayer();

        gameStateManager = new GameStateManager(playerManager.getPlayer());
        huntingManager = new HuntingManager(
                playerManager.getPlayer(),
                preyFactory,
                zombieFactory,
                miniGameFactory,
                scanner
        );
        menuManager = new MenuManager(scanner);

        gameLoop();
    }

    private void gameLoop() {
        while (gameStateManager.isGameRunning()) {
            playerManager.displayStatus();
            menuManager.displayMainMenu();

            int choice = menuManager.getValidChoice(1, 3);

            if (choice == 1) {
                huntingManager.huntAlone();
            } else if (choice == 2) {
                huntingManager.hireZombies();
            } else {
                System.out.println("\nGame ended. Your final score: " + playerManager.getPlayer().getPoints());
                return;
            }

            playerManager.getPlayer().decrementTurns();
        }

        gameStateManager.endGame();
    }
}