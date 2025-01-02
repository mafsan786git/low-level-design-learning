### Structural Design Patterns
Structural design patterns focus on how objects and classes are composed to form larger structures while ensuring that the resulting system remains flexible and efficient. 
These patterns deal with the organization and relationships of objects and classes to make systems easier to develop and maintain.

**Here are the key structural design patterns and their purposes:**  
1. **Adapter Pattern (`IMP***`):** 
   1. `Purpose :` Converts the interface of a class into another interface clients expect. This enables incompatible classes to work together.
   2. `Use Case :` When you have a legacy system or third-party code that doesn’t match your application’s requirements.
   3. `Example :` A power adapter that allows a plug with one type of socket to fit into a different type of power outlet.
   
2. **Bridge Pattern :**
   1. `Purpose :` Decouples an abstraction from its implementation so the two can evolve independently. 
   2. `Use Case :` When you want to separate the interface and implementation to allow multiple variations. 
   3. `Example :` A remote control (interface) can work with different types of devices (implementations) like a TV or a sound system.
   
3. **Composite Pattern :**
   1. `Purpose :` Composes objects into tree structures to represent part-whole hierarchies. Clients can treat individual objects and composites uniformly. 
   2. `Use Case :` When you need to represent a hierarchy of objects where both single objects and groups of objects should be treated the same. 
   3. `Example :` A file system where files and directories are treated uniformly.
   
4. **Decorator Pattern (`IMP***`):**
   1. `Purpose :` Adds responsibilities to objects dynamically without modifying their code. 
   2. `Use Case :` When you need to extend the behavior of objects in a flexible way. 
   3. `Example :` Adding different toppings (e.g., cheese, pepperoni) to a pizza without altering the base pizza class.

5. **Facade Pattern (`IMP**`):**
   1. `Purpose:` Provides a simplified interface to a larger and more complex subsystem.
   2. `Use Case:` When you want to provide a unified interface to a set of interfaces in a subsystem.
   3. `Example:` A universal remote control that simplifies operating various devices like a TV, DVD player, and sound system.

6. **Flyweight Pattern :**
   1. `Purpose:` Reduces memory usage by sharing common parts of the state between multiple objects.
   2. `Use Case:` When a large number of similar objects are used, and memory optimization is essential.
   3. `Example:` Characters in a text editor sharing the same font style and size attributes.

7. **Proxy Pattern (`IMP***`):**
   1. `Purpose :` Provides a surrogate or placeholder for another object to control access to it.
   2. `Use Case :` When you want to add a layer of control, such as lazy initialization, access control, or logging.
   3. `Example :` A bank account proxy that controls access to the actual account object.


**Common Benefits of Structural Design Patterns:**
1. `Scalability :` Simplifies the addition of new features or components.
2. `Maintainability :`Promotes better organization and readability of code.
3. `Reusability :` Encourages the reuse of existing components in new systems.
4. `Decoupling :` Reduces dependencies between components, making the system more robust.



