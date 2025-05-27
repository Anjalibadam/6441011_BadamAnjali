public class OperatorPrecedence {
    public static void main(String[] args) {
        // Example 1
        int result1 = 10 + 5 * 2;
        System.out.println("Result of 10 + 5 * 2 = " + result1);
        // Explanation: Multiplication (*) is done before addition (+)
        // So, 5 * 2 = 10, then 10 + 10 = 20

        // Example 2
        int result2 = (10 + 5) * 2;
        System.out.println("Result of (10 + 5) * 2 = " + result2);
        // Explanation: Parentheses alter the order
        // So, 10 + 5 = 15, then 15 * 2 = 30

        // Example 3
        int result3 = 100 / 10 + 5 * 3 - 2;
        System.out.println("Result of 100 / 10 + 5 * 3 - 2 = " + result3);
        // Explanation:
        // Step 1: 100 / 10 = 10
        // Step 2: 5 * 3 = 15
        // Step 3: 10 + 15 = 25
        // Step 4: 25 - 2 = 23

        // Example 4
        int result4 = 8 + 2 * (15 - 5);
        System.out.println("Result of 8 + 2 * (15 - 5) = " + result4);
        // Explanation:
        // Step 1: (15 - 5) = 10
        // Step 2: 2 * 10 = 20
        // Step 3: 8 + 20 = 28
    }
}