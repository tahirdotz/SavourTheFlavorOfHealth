import java.io.IOException;

public class TerminalUtilForGuessTheNumber {

    public static void clearTerminal() {
        try {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            for (int i = 0; i < 20; i++) {
                System.out.println();
            }
        }
    }
    }


