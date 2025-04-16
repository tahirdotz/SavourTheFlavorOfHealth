import java.util.Random;

public class MiniGameFactory {
    private final Random random = new Random();

    public MiniGames createRandomMiniGame() {
        if (random.nextBoolean()) {
            return new NumberGuessingGame();
        } else {
            Timer timer = new TimerImpl();
            return new FindTheNumberGame(timer);
        }
    }
}
