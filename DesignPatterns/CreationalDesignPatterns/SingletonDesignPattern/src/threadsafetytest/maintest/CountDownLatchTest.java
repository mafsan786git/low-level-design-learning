package threadsafetytest.maintest;
import threadsafetytest.Singleton;

import java.util.concurrent.CountDownLatch;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        // Store all instance hashcodes to check for duplicates
        Set<Integer> hashCodes = Collections.newSetFromMap(new ConcurrentHashMap<>());
        final int THREAD_COUNT = 1000;

        // CountDownLatch ensures all threads start at the same time
        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(THREAD_COUNT);

        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(() -> {
                try {
                    // Wait for the signal to start
                    startLatch.await();

                    // Get singleton instance and store its hashcode
                    Singleton singleton = Singleton.getInstance();
                    hashCodes.add(singleton.hashCode());
                    singleton.incrementValue();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    endLatch.countDown();
                }
            }).start();
        }

        // Start all threads simultaneously
        startLatch.countDown();

        // Wait for all threads to complete
        endLatch.await();

        // Verify results
        System.out.println("Number of unique instances created: " + hashCodes.size());
        System.out.println("Final value: " + Singleton.getInstance().getValue());

        // If hashCodes.size() > 1, we have a thread safety problem
        if (hashCodes.size() > 1) {
            System.out.println("THREAD SAFETY VIOLATION: Multiple instances were created!");
        } else if (Singleton.getInstance().getValue() != THREAD_COUNT) {
            System.out.println("THREAD SAFETY VIOLATION: Race condition in value increment!");
        } else {
            System.out.println("No thread safety violations detected.");
        }
    }
}
