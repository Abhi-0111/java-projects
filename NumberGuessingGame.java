import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    static final int MIN = 1;
    static final int MAX = 100;
    static final int MAX_ATTEMPTS = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("===========================================");
        System.out.println("        NUMBER GUESSING GAME               ");
        System.out.println("===========================================");
        System.out.println("Rules:");
        System.out.println("  - Guess a number between " + MIN + " and " + MAX);
        System.out.println("  - You have " + MAX_ATTEMPTS + " attempts per round");
        System.out.println("  - After each guess, you get a hint");
        System.out.println("===========================================\n");

        int totalRounds = 0;
        int totalWins = 0;

        while (playAgain) {
            totalRounds++;
            int secretNumber = random.nextInt(MAX - MIN + 1) + MIN;
            int attemptsUsed = 0;
            boolean won = false;

            System.out.println("Round " + totalRounds + " - A new number has been chosen.");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts.\n");

            while (attemptsUsed < MAX_ATTEMPTS) {
                int remaining = MAX_ATTEMPTS - attemptsUsed;
                System.out.print("Attempt " + (attemptsUsed + 1) + "/" + MAX_ATTEMPTS
                        + " | Attempts left: " + remaining + " | Enter your guess: ");

                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a whole number between "
                            + MIN + " and " + MAX + ".\n");
                    continue;
                }

                if (guess < MIN || guess > MAX) {
                    System.out.println("Out of range. Please guess between "
                            + MIN + " and " + MAX + ".\n");
                    continue;
                }

                attemptsUsed++;

                if (guess == secretNumber) {
                    System.out.println("\nCORRECT! You guessed the number " + secretNumber
                            + " in " + attemptsUsed + " attempt(s).");
                    won = true;
                    totalWins++;
                    break;
                } else if (guess < secretNumber) {
                    int diff = secretNumber - guess;
                    System.out.print("Too low.  ");
                    printHint(diff);
                } else {
                    int diff = guess - secretNumber;
                    System.out.print("Too high. ");
                    printHint(diff);
                }

                System.out.println();
            }

            if (!won) {
                System.out.println("\nOut of attempts. The secret number was: " + secretNumber);
            }

            System.out.println("\n-------------------------------------------");
            System.out.println("Score: " + totalWins + " win(s) out of " + totalRounds + " round(s)");
            System.out.println("-------------------------------------------");

            System.out.print("\nPlay again? (yes / no): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            playAgain = answer.equals("yes") || answer.equals("y");
            System.out.println();
        }

        System.out.println("===========================================");
        System.out.println("Thanks for playing!");
        System.out.println("Final Score: " + totalWins + " win(s) in " + totalRounds + " round(s)");
        System.out.println("===========================================");

        scanner.close();
    }

    static void printHint(int diff) {
        if (diff <= 5) {
            System.out.println("Hint: Very close, within 5.");
        } else if (diff <= 15) {
            System.out.println("Hint: Getting warm, within 15.");
        } else if (diff <= 30) {
            System.out.println("Hint: Getting colder, within 30.");
        } else {
            System.out.println("Hint: Far off, more than 30 away.");
        }
    }
}