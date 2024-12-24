package singleton;

public class EagerSingletonDesignPattern {
    // Instances are created when class is loaded
    private static final EagerSingletonDesignPattern instance = new EagerSingletonDesignPattern();

    private EagerSingletonDesignPattern() {
    }

    public static EagerSingletonDesignPattern getInstance() {
        return instance;
    }
}
