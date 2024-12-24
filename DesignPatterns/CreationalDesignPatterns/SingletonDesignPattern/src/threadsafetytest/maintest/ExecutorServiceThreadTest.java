package threadsafetytest.maintest;
import threadsafetytest.Singleton;

import java.util.concurrent.*;
import java.util.*;

public class ExecutorServiceThreadTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        final int THREAD_COUNT = 100;
        final int TASKS_PER_THREAD = 1000;

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        Set<Integer> hashCodes = Collections.newSetFromMap(new ConcurrentHashMap<>());
        List<Future<Integer>> futures = new ArrayList<>();

        // Submit tasks
        for (int i = 0; i < THREAD_COUNT * TASKS_PER_THREAD; i++) {
            Future<Integer> future = executorService.submit(() -> {
                Singleton singleton = Singleton.getInstance();
                singleton.incrementValue();
                return singleton.hashCode();
            });
            futures.add(future);
        }

        // Collect results
        for (Future<Integer> future : futures) {
            hashCodes.add(future.get());
        }

        executorService.shutdown();

        // Verify results
        System.out.println("Test completed with " + THREAD_COUNT + " threads");
        System.out.println("Each thread performed " + TASKS_PER_THREAD + " operations");
        System.out.println("Number of unique instances: " + hashCodes.size());
        System.out.println("Final value: " + Singleton.getInstance().getValue());
        System.out.println("Expected value: " + (THREAD_COUNT * TASKS_PER_THREAD));

        // Comprehensive result analysis
        boolean isThreadSafe = hashCodes.size() == 1 &&
                Singleton.getInstance().getValue() == (THREAD_COUNT * TASKS_PER_THREAD);

        if (isThreadSafe) {
            System.out.println("The Singleton implementation is thread-safe");
        } else {
            System.out.println("Thread safety violations detected:");
            if (hashCodes.size() > 1) {
                System.out.println("- Multiple instances were created");
            }
            if (Singleton.getInstance().getValue() != (THREAD_COUNT * TASKS_PER_THREAD)) {
                System.out.println("- Race condition in value increment");
            }
        }
    }
}
