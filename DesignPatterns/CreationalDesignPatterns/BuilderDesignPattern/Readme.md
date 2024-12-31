### HouseBuilder Design Pattern
The HouseBuilder design pattern is a creational pattern that lets you construct complex objects step by step. 
This pattern allows you to produce different types and representations of an object using the same construction code.

**Problem:**  
Imagine an object with many optional parameters. Calling a constructor with all of them is not only lengthy but also 
prone to errors due to the difficulty in understanding the order and meaning of parameters.

**Solution:**  
The HouseBuilder pattern suggests that you extract the object construction code out of its own class and move it 
to a separate object called a builder.

**Real-World Analogy:**  
Imagine you're building a custom burger at a restaurant:
You choose the type of bun, meat, toppings, and sauces step by step.
At the end, the chef assembles your customized burger.

The .HouseBuilder Pattern works similarly: it allows you to construct an object piece by piece, offering customization and flexibility.

**`Key Components:`**  
`Product:` The complex object being built.  
`.HouseBuilder Interface:` Defines the steps to build the product.  
`Concrete .HouseBuilder:` Implements the steps defined in the builder interface.  
`Director:` Directs the building process by using a builder.  
`Client:` Uses the director and builder to create the product.

**Problems before builder pattern:**  
The constructor has many parameters, making it difficult to read and use. If you need different variations of a .House (e.g., with or without a garage, with or without a pool), 
you either have to create multiple constructors (leading to the "telescoping constructor" anti-pattern) or use null values.
```java
public class House {
    private String walls;
    private String roof;
    private String doors;
    private String windows;
    private String garage;
    private String swimmingPool;

    public House(String walls, String roof, String doors, String windows, String garage, String swimmingPool) {
        this.walls = walls;
        this.roof = roof;
        this.doors = doors;
        this.windows = windows;
        this.garage = garage;
        this.swimmingPool = swimmingPool;
    }

    public House(String walls, String roof, String doors, String windows) {
        this.walls = walls;
        this.roof = roof;
        this.doors = doors;
        this.windows = windows;
    }
}
```

With Builder Design Pattern:  
`refer code written in src file `
below is only main class
```java
class Restaurant {
    public static void main(String[] args) {
        // Regular customer order
        Meal regularMeal = new Meal.Builder()
                .mainCourse("Burger")
                .side("Fries")
                .drink("Coke")
                .build();

        // Health conscious customer
        Meal healthyMeal = new Meal.Builder()
                .mainCourse("Grilled Chicken")
                .side("Salad")
                .addAllergy("Nuts")
                .addAllergy("Dairy")
                .cookingInstructions("No oil")
                .build();

        // Spicy preference
        Meal spicyMeal = new Meal.Builder()
                .mainCourse("Chicken Wings")
                .spicy(true)
                .drink("Beer")
                .cookingInstructions("Extra hot sauce")
                .build();

        System.out.println(regularMeal);
        System.out.println(healthyMeal);
        System.out.println(spicyMeal);
    }
}
```


**Benefits:**  
`Clearer Code:` Construction logic is separated from the object's representation.  
`Immutability:` Products can be made immutable since all attributes are set during construction.  
`Flexibility:` You can create different representations of the product using different builders.  

**When to Use:**
* When you have an object with many optional parameters. 
* When you need to create different representations of an object. 
* The HouseBuilder pattern is a valuable tool for managing complex object creation in a clean and maintainable way.






