public class GameStateManager {
    private Player player;
    private boolean gameRunning;

    public GameStateManager(Player player) {
        this.player = player;
        this.gameRunning = true;
    }

    public boolean isGameRunning() {
        return gameRunning && player.isAlive() &&
                player.getRemainingTurns() > 0 &&
                player.getPoints() < player.getTargetPoints();
    }

    public void endGame() {
        gameRunning = false;
        System.out.println("\n==================");
        System.out.println("GAME OVER");
        System.out.println("==================");

        if (player.getPoints() >= player.getTargetPoints()) {
            System.out.println("CONGRATULATIONS! You reached your target of " + player.getTargetPoints() + " points!");
        } else if (!player.isAlive()) {
            System.out.println("You died! Your health reached zero.");
            System.out.println("Final score: " + player.getPoints());
        } else {
            System.out.println("You ran out of turns!");
            System.out.println("Final score: " + player.getPoints() + " (Target was: " + player.getTargetPoints() + ")");
        }
    }
}