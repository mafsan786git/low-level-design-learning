## Creational Design Patterns
Definitions :  
Creational design patterns are a category of design patterns in software development 
that focus on the creation of objects in a manner that enhances flexibility and reusability of the code. 
Instead of directly instantiating objects, these patterns abstract the instantiation process, 
making the system more robust to changes and easier to manage.

1. **Singleton Pattern:**  
   Purpose: Ensures that a class has only one instance and provides a global point of access to it.  
   Use Case: Managing shared resources like configuration settings, logging, or connection pools.
2. **Factory Method Pattern:**  
      Purpose: Defines an interface for creating objects but allows subclasses to alter the type of objects that will be created.  
      Use Case: When a class can't anticipate which class of objects it must create.
3. **Abstract Factory Pattern:**  
   Purpose: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.  
   Use Case: Ensures a set of products work together, often used in cross-platform GUI applications.
4. **Builder Pattern:**  
   Purpose: Separates the construction of a complex object from its representation so that the same construction process can create different representations.  
   Use Case: Constructing complex objects step by step.
5. **Prototype Pattern:**  
      Purpose: Allows cloning objects, even complex ones, without coupling to their specific classes.  
      Use Case: When creating an object is resource-intensive, and a similar object can be cloned and modified.
