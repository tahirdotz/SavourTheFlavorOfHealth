import java.io.IOException;

public class TerminalUtilForGuessTheNumber {

        public static void clearTerminal() throws IOException, InterruptedException {
            if (System.getProperty("os.name").toLowerCase().contains("windows")) {

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        }
    }


