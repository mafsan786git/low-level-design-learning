### Singleton Design Pattern

The Singleton pattern ensures that a class has only one instance throughout the entire application lifecycle while providing global access to that instance. 
Think of it like having a single shared resource - similar to how a company might have just one CEO or how a computer system has one operating system running at a time.


#### Let's explore different ways to implement Singleton, starting from the simplest and moving to more sophisticated versions:
`**Eager Initialization (Basic Static):**`  
This approach is the simplest but has important characteristics to consider. The instance is created when the class loads, even if it's never used. 
While this ensures thread safety through the JVM's class loading mechanism, it might waste resources if the instance is heavy and not always needed. 
It's best used when you're certain the instance will be needed and the initialization cost is low.
```java
public class EagerSingletonDesignPattern {
    // Instances are created when class is loaded and its thread safe
    private static final EagerSingletonDesignPattern instance = new EagerSingletonDesignPattern();

    private EagerSingletonDesignPattern() {
    }

    public static EagerSingletonDesignPattern getInstance() {
        return instance;
    }
}
```
---
`**Lazy Initialization (Basic):**`  
This version only creates the instance when first requested, saving resources. However, 
it's not thread-safe. If multiple threads call getInstance() simultaneously, you might end up with multiple instances. 
This makes it suitable only for single-threaded environments.
```java
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
```
---
`**Thread-Safe Synchronization:**`  
By adding the synchronized keyword, we ensure thread safety. However, synchronization adds overhead because threads must wait for the lock to be released, 
even after initialization. This impacts performance, especially in applications with high concurrency.
```java
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
```
---
`**Double-Checked Locking:**`  
This pattern attempts to reduce the synchronization overhead by checking the instance twice. 
The volatile keyword is crucial here to prevent partially constructed instances from being visible to other threads. 
While this pattern was popular, it's complex and can be tricky to implement correctly.
```java
public class DoubleCheckedLockingSingleton {
    private  static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if(instance != null) return instance;

        synchronized (DoubleCheckedLockingSingleton.class){
            if (instance == null) {
                instance = new DoubleCheckedLockingSingleton();
            }
        }
        return  instance;

    }
}
```
---
`**Bill Pugh Singleton (Static Holder):**`  
This is considered the best approach for most cases. It provides lazy initialization through JVM's class loading mechanism, ensuring thread safety without using synchronization. 
The inner class isn't loaded until getInstance() is called, making it both efficient and thread-safe.
```java
public class BillPughStaticHolderSingleton {
    private BillPughStaticHolderSingleton(){}

    private static class SingletonHolder{
        private static final BillPughStaticHolderSingleton INSTANCE = new BillPughStaticHolderSingleton();
    }

    public static BillPughStaticHolderSingleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
```
---
`**Enum Singleton:**`  
The enum approach, introduced in Java 5, is the simplest way to create a thread-safe singleton. 
It's inherently serializable and provides strong guarantees against multiple instantiation, even in cases of serialization or reflection. 
However, it's less flexible because enum types can't inherit from classes.
```java
public enum EnumSingleton {
    INSTANCE;

    public static void getInstance(){
        //we can return instance of any class
    }
}
```
---


### _Here's a practical comparison of when to use each approach:_
1. **Consider Eager Initialization when:**
   1. The instance is lightweight 
   2. You're certain it will be needed 
   3. Application startup time isn't crucial 
2. **Use Bill Pugh (Static Holder) when:**
   1. You need lazy initialization 
   2. Thread safety is important 
   3. You want a clean, efficient solution
3. **Choose Enum Singleton when:**
   1. Simplicity is paramount 
   2. You need serialization support 
   3. Reflection attack prevention is important
4. Consider Double-Checked Locking only when:
   1. You're working with legacy code 
   2. You need fine-grained control over instantiation 
   3. You understand the complexities involved

