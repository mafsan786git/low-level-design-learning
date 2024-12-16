# Liskov Substitution Principle (LSP)
Definition:  
Subtypes must be substitutable for their base types without altering the correctness of the program. In other words, if you have a parent class or interface, 
you should be able to replace it with any of its subclasses without breaking functionality.  
The LSP ensures that inheritance is used properly. Violating it often indicates a problem with the hierarchy design or an inappropriate abstraction.

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
