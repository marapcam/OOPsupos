import java.util.Random;
import java.util.Scanner;

public class HiLoGame {
    int difficulty;
    int targetNumber;
    int guessesRemaining;
    Scanner scanner;

    public static void main(String[] args) {
        HiLoGame game = new HiLoGame();
        game.start();
    }

    public void start() {
        scanner = new Scanner(System.in);

        while (true) {
            setDifficulty();
            targetNumber = new Random().nextInt(100) + 1;
            guessesRemaining = difficulty * 3;
            System.out.println("Enter a number from 1 to 100");
            while (guessesRemaining > 0) {
                guess();
                if (guessesRemaining == 10) {
                    break;
                }
                if (guessesRemaining <= 0) {
                    break;
                }
            }
            if (guessesRemaining != 10){
                gameOver();
            }
        }

    }

    public void setDifficulty() {
        System.out.println("Enter a difficulty (1 = hardest - 3 = easiest): ");
        String inp = scanner.nextLine();
        int dif = Integer.parseInt(inp);
        if (dif < 4 && dif > 0) {
            difficulty = dif;
        } else {difficulty = 2;}
    }

    public void outputResponse (int highlow) {
        if (highlow == 0) {
            System.out.println("You win!");
            gameOver();
        } else if (highlow > 0) {
            System.out.println("Too high");
        } else {
            System.out.println("Too low");
        }
    }

    public void gameOver () {
        updateScoreboard(guessesRemaining != 0);
        if (guessesRemaining == 0) {
            System.out.println("You have run out of guesses :( ");
            System.out.println("The correct number was " + targetNumber);
        } else {
            guessesRemaining = 10;
        }
        System.out.println("Press enter for a rematch");
        scanner.nextLine();
    }

    public void guess () {
        guessesRemaining--;
        String inp = scanner.nextLine();
        int guess = Integer.parseInt(inp);
        int difference = guess - targetNumber;
        outputResponse(difference);
    }

    public void updateScoreboard(boolean won) {
        // stats in a file would be updated if won or lost
        // difficulty level and number of guesses also included
    }

}
