package singleton;

public class SingletonPerformanceMain {
    public static void main(String[] args) {
        // Test eager initialization
        long start = System.nanoTime();
        EagerSingletonDesignPattern.getInstance();
        System.out.println("Eager init time: " + (System.nanoTime() - start));

        // Test lazy initialization with Bill Pugh
        start = System.nanoTime();
        BillPughStaticHolderSingleton instance1 = BillPughStaticHolderSingleton.getInstance();
        System.out.println("Bill Pugh init time: " + (System.nanoTime() - start));

        // Test thread safety with multiple threads
        Runnable task = () -> {
            BillPughStaticHolderSingleton instance = BillPughStaticHolderSingleton.getInstance();
            System.out.println("Thread " + Thread.currentThread().getId() +
                    " got instance: " + instance.hashCode());
            System.out.println(instance1 == instance); //this should be always true
        };

        for (int i = 0; i < 5; i++) {
            new Thread(task).start();
        }
    }
}
