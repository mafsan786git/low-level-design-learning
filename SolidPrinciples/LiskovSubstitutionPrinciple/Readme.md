# Liskov Substitution Principle (LSP)
Definition:  
Subtypes must be substitutable for their base types without altering the correctness of the program. In other words, if you have a parent class or interface, 
you should be able to replace it with any of its subclasses without breaking functionality.  
The LSP ensures that inheritance is used properly. Violating it often indicates a problem with the hierarchy design or an inappropriate abstraction.

The Liskov Substitution Principle (LSP) is an object-oriented programming principle that states that subclasses can replace their superclasses without altering the program's correctness:  
1. Explanation:  
    The LSP requires that subclasses can take on the responsibilities of their superclasses without any side effects or behavioral changes. In other words, code that works with a specific type of object should also work with any of its subclasses.
2. Example:  
    For example, if you have a class called Animal and another class called Dog that inherits from Animal, then you should be able to use Dog in any place where you would normally use Animal.
3. Importance
    The LSP promotes reusability, modularity, and maintainability by ensuring that components within a hierarchy can be easily interchanged.
4. Indicators of LSP violations
   * Conditional logic in client code
   * Empty implementations of methods in subclasses
   * Throwing unexpected exceptions from a subclass method

Bad code (Violating LSP)
```java
public interface IEmployee {
    float getMinimumSalary();
    float calculateBonus(float salary);
}

public class PermanentEmployee implements IEmployee {
    @Override
    public float getMinimumSalary() {
        return 15000;

    }

    @Override
    public float calculateBonus(float salary) {
        return (float) (salary * 0.8);
    }
}

public class ContractEmployee implements IEmployee {
    @Override
    public float getMinimumSalary() {
        return 10000;

    }

    @Override
    public float calculateBonus(float salary) {
        throw new UnsupportedOperationException("No implementation available");
    }
}
```
as we can see calculateBonus(value) is not supported for `ContractEmployee` but still we need to implement
which is making wrong behaviour of method correctness.


GOOD Code (Adhering to LSP)
To adhere to LSP, design the hierarchy properly by separating interface
```java
public interface IEmployee {
    float getMinimumSalary();
}

public interface IEmployeeBonus {
    float calculateBonus(float salary);
}

public class PermanentEmployee implements IEmployee,IEmployeeBonus {
    @Override
    public float getMinimumSalary() {
        return 15000;

    }

    @Override
    public float calculateBonus(float salary) {
        return (float) (salary * 0.08);
    }
}

public class ContractEmployee implements IEmployee {
    @Override
    public float getMinimumSalary() {
        return 10000;

    }
}
```
as we can see now `ContractEmployee` don't need to implement.

Key Principles for LSP:  
1. `Respect the Parent Contract`: Subtypes must fulfill the promises of the parent class or interface.
2. `void Unexpected Behavior`: Subtypes should not throw exceptions or behave differently for operations defined by the parent. 
3. `Design for Polymorphism`: Use proper abstractions and ensure all subtypes adhere to the intended contract.


Conclusion:  
1. `Bad Code`: Subtypes deviate from the expected behavior, breaking polymorphism and violating LSP.
2. `Good Code`: Subtypes respect the base type's contract and can replace it without altering program correctness, making the system reliable, predictable, and easy to maintain.
