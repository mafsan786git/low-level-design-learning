package threadsafetytest;

public class Singleton {
    private static Singleton instance;
    private int value=0;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public int getValue(){
        return value;
    }

    public void incrementValue(){
        value++;
    }
}
