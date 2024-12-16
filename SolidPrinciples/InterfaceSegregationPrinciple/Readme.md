# Interface Segregation Principle (ISP) 
**Definition:**  
The Interface Segregation Principle (ISP) states that a class should not be forced to implement interfaces it does not use. Instead of creating a large, monolithic interface, you should split it into smaller, more specific interfaces tailored to the needs of individual clients.  
The principle ensures that:
1. Interfaces are cohesive.
2. Clients only depend on what they need.

**Bad Code (Violating ISP)**
```java
public interface IWorker {
    String work();
    String sleep();
}

public class HumanWorker implements IWorker {
    @Override
    public String work() {
        return "Human is working";
    }

    @Override
    public String sleep() {
        return "Human is sleeping";
    }
}

public class RobotWorker implements IWorker {
    @Override
    public String work() {
        return "Robot is working";
    }

    @Override
    public String sleep() {
        throw new UnsupportedOperationException("Robot cannot sleep");
    }
}
```
we can see above code as `IWorker` interface is forcing to implement sleep() in `RobotWorker`,
breaking the design and confusing clients.

**GOOD Code (Adhering to ISP)**
splitting large interface into smaller.
```java
public interface ISleepable {
    String sleep();
}

public interface IWorkable {
    String work();
}

public class HumanWorker implements ISleepable,IWorkable{
    @Override
    public String work() {
        return "Human is working";
    }

    @Override
    public String sleep() {
        return "Human is sleeping";
    }
}

public class RobotWorker implements IWorkable{
    @Override
    public String work() {
        return "Robot is working";
    }
}
```
**Key Improvements:** 
1. `Cohesive Interfaces`: Each interface is responsible for a single type of worker (robot or human).
2. `No Unused Methods`: Implementing classes are no longer forced to include methods they don’t use, reducing clutter and confusion.
3. `Extensible`: If a new type of worker is added, it won’t affect existing interfaces or classes.

**Conclusion:**  
1. `Bad Code`: Large interfaces with unrelated methods force implementations to include or throw errors for unused methods, violating ISP.
2. `Good Code`: Small, specific interfaces ensure that classes only depend on what they truly need, improving cohesion, clarity, and maintainability.




