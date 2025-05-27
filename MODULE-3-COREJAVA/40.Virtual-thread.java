public class VirtualThreadsExample {

    private static final int THREAD_COUNT = 100_000;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Running with virtual threads...");
        long virtualStart = System.currentTimeMillis();
        runVirtualThreads();
        long virtualEnd = System.currentTimeMillis();
        System.out.println("Virtual threads time: " + (virtualEnd - virtualStart) + " ms");

        System.out.println("\nRunning with traditional threads...");
        long traditionalStart = System.currentTimeMillis();
        runTraditionalThreads();
        long traditionalEnd = System.currentTimeMillis();
        System.out.println("Traditional threads time: " + (traditionalEnd - traditionalStart) + " ms");
    }

    private static void runVirtualThreads() throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = Thread.startVirtualThread(() -> {
                // Simple task: print a message (comment out to reduce console spam)
                // System.out.println("Hello from virtual thread " + Thread.currentThread().threadId());
            });
        }

        for (Thread t : threads) {
            t.join();
        }
    }

    private static void runTraditionalThreads() throws InterruptedException {
        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(() -> {
                // Simple task: print a message (comment out to reduce console spam)
                // System.out.println("Hello from traditional thread " + Thread.currentThread().getId());
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }
    }
}
