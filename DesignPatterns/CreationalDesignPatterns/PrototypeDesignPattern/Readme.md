### Prototype Design Pattern
The Prototype Design Pattern is a creational design pattern used to create new objects by copying or cloning existing objects. 
Instead of creating an object from scratch, a prototype object is used as a blueprint, and new objects are created by duplicating it.

**Key Features :**  
`Cloning:` The pattern focuses on creating objects by copying an existing instance (prototype).  
`Performance:` It's particularly useful when object creation is expensive in terms of time or resources.  
`Decoupling:` Reduces the dependency on specific classes or constructors for object creation.

**Components :**  
`Prototype Interface:` Declares the method for cloning objects.  
`Concrete Prototype:` Implements the clone method and provides the ability to copy itself.  
`Client:` Creates new objects by cloning the prototype.


**When to Use Prototype Pattern**
* When object creation is resource-intensive and needs to be minimized. 
* When the system needs to avoid creating new instances from scratch. 
* To simplify object creation when the object's configuration is complex.
