import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100
        int targetNumber = random.nextInt(100) + 1;
        int guess;
        
        System.out.println("Guess a number between 1 and 100:");

        // Loop until the correct guess
        while (true) {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();

            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed the correct number: " + targetNumber);
                break;
            } else if (guess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        scanner.close();
    }
}