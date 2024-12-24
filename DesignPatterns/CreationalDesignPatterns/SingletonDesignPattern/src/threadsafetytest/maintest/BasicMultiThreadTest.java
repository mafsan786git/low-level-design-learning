package threadsafetytest.maintest;

import threadsafetytest.Singleton;

public class BasicMultiThreadTest {
    public static void main(String[] args) {
        // Create multiple threads that access the Singleton simultaneously
        int threadCount = 10000;
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                Singleton singleton = Singleton.getInstance();
                // Store the instance's hashcode to verify if we get different instances
                System.out.println("Thread " + Thread.currentThread().getId() +
                        " got instance with hashcode: " + singleton.hashCode());
                singleton.incrementValue();
            });
        }

        // Start all threads at roughly the same time
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Check final value
        System.out.println("Final value: " + Singleton.getInstance().getValue());
    }
}
