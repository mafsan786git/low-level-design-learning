package singleton;

public class LazySingletonDesignPattern {
    private static LazySingletonDesignPattern instance;

    private LazySingletonDesignPattern() {
    }

    // Created when required but not thread-safe
    public static LazySingletonDesignPattern getInstance(){
        if(instance != null) return instance;
        instance = new LazySingletonDesignPattern();
        return instance;
    }
}
