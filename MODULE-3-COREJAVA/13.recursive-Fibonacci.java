import java.util.Scanner;

public class RecursiveFibonacci {

    // Recursive method to calculate Fibonacci number
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0; // Base case 1
        } else if (n == 1) {
            return 1; // Base case 2
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for a positive integer
        System.out.print("Enter a positive integer (n) to find the nth Fibonacci number: ");
        int n = scanner.nextInt();

        // Input validation
        if (n < 0) {
            System.out.println("Invalid input! Please enter a positive integer.");
        } else {
            int result = fibonacci(n);
            System.out.println("Fibonacci number at position " + n + " is: " + result);
        }

        scanner.close();
    }
}