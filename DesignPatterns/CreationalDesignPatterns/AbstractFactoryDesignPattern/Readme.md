### Abstract Factory Design Pattern
The Abstract Factory Design Pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. 
It allows you to produce objects that belong to a family, ensuring that related objects are compatible with one another.

**Key Features :**  
`Encapsulation of Object Families:` Centralizes the creation of families of objects.  
`Loose Coupling:` The client is decoupled from the concrete implementations of objects.  
`Flexibility:` New families of products can be added without altering the existing code.

**Components :**  
`Abstract Factory:` Declares a set of methods to create abstract products.  
`Concrete Factory:` Implements the abstract factory methods to produce specific families of products.  
`Abstract Product:` Declares the interface for a type of product.  
`Concrete Product:` Implements the abstract product interface.  
`Client:` Uses the factories and products without knowing their specific implementations.

**When to Use Abstract Factory :**  
* When you need to create families of related objects that must be used together. 
* When you want to enforce consistency among related objects. 
* When the system should be independent of how its objects are created.

**Scenario :**   
**Vehicle Parts Manufacturing**  
    **Problem Statement:**  
    Imagine a car manufacturing company that produces different types of vehicles (e.g., cars and motorcycles). 
    Each type of vehicle requires a specific set of components, such as engines and tires. The Abstract Factory Design Pattern can be used 
    to create these components while ensuring compatibility between them.

**Code Example :**  
`all code are written in src file`,  
here is main class
```java
public class VehicleDemoMain {
    public static void main(String[] args) {
        //factory for car component
        VehicleFactory vehicleFactory = new CarFactory();
        Engine carEngine = vehicleFactory.createEngine();
        Tyre carTyre = vehicleFactory.createTyre();

        System.out.println("Car Factory:");
        carEngine.design();
        carTyre.manufacture();

        //factory for motorCycle component
        VehicleFactory motorCycleFactory = new MotorCycleFactory();
        Engine motorCycleFactoryEngine = motorCycleFactory.createEngine();
        Tyre motorCycleFactoryTyre = motorCycleFactory.createTyre();

        System.out.println("Car Factory:");
        motorCycleFactoryEngine.design();
        motorCycleFactoryTyre.manufacture();
    }
}
```

**Explanation :**  
`Abstract Products (Engine and Tire):`  
* Define the interface for the components.

`Concrete Products (CarEngine, MotorcycleEngine, CarTire, MotorcycleTire):`
* Implement the specific behavior for each type of component.

`Abstract Factory (VehicleFactory):`
* Declares methods to create related components (e.g., createEngine, createTire).

`Concrete Factories (CarFactory, MotorcycleFactory):`
* Implement the abstract factory methods to produce components specific to a type of vehicle.

`Client Code:`
* Uses the factories and interacts with components via their abstract interfaces, ensuring compatibility without knowing their concrete implementations.



**Advantages :**  
`Consistency:` Ensures that components of a product family are compatible.  
`Scalability:` Adding new product families is straightforward (e.g., add a TruckFactory).  
`Encapsulation:` Hides the concrete classes from the client.
