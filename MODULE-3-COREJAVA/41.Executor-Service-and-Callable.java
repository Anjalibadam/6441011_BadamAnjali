import java.util.concurrent.*;
import java.util.*;

public class CallableExecutorExample {

    public static void main(String[] args) {
        // Create a fixed thread pool with 4 threads
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // List to hold Future objects
        List<Future<Integer>> futures = new ArrayList<>();

        // Submit 5 callable tasks
        for (int i = 1; i <= 5; i++) {
            int number = i;
            Callable<Integer> task = () -> {
                // Simulate computation
                Thread.sleep(500);
                return number * number;
            };
            futures.add(executor.submit(task));
        }

        // Retrieve results
        for (int i = 0; i < futures.size(); i++) {
            try {
                Integer result = futures.get(i).get(); // Blocking call
                System.out.println("Result of Task " + (i + 1) + ": " + result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown the executor
        executor.shutdown();
    }
}
