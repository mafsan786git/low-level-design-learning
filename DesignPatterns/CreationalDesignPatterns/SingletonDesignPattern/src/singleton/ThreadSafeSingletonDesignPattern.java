package singleton;

public class ThreadSafeSingletonDesignPattern {
    private static ThreadSafeSingletonDesignPattern instance;

    private ThreadSafeSingletonDesignPattern() {
    }

    public static synchronized ThreadSafeSingletonDesignPattern getInstance() {
        if (instance != null) return instance;
        instance = new ThreadSafeSingletonDesignPattern();
        return instance;
    }
}
