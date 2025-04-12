import java.util.Scanner;

public class FindTheNumberGame implements Minigames {
    private final Timer timer;
    private static final int TIME_LIMIT = 5000;

    public FindTheNumberGame(Timer timer) {
        this.timer = timer;
    }

    @Override
    public int playGame() {
        timer.startTimer();
        int num1 = (int) (Math.random() * 10);
        int num2 = (int) (Math.random() * 10);
        int correctAnswer = num1 + num2;
        System.out.println("Solve the math problem: " + num1 + " + " + num2);
        Scanner scanner = new Scanner(System.in);

        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;
        while (elapsedTime < TIME_LIMIT)
        {
            if(scanner.hasNextInt())
            {
                int answer = scanner.nextInt();
                if(answer == correctAnswer)
                {
                    System.out.println("Correct Answer Dead boy");
                }
                else
                {
                    System.out.println("Wrong Answer Fool");
                }
                break;
            }
            elapsedTime=System.currentTimeMillis()-startTime;

        }
        if (elapsedTime >= TIME_LIMIT && !timer.isTimeUp()) {
            System.out.println("Time's up! The correct answer was " + correctAnswer);
        }

        scanner.close();
        return correctAnswer;

    }
}

