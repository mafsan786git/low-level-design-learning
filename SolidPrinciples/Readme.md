## Solid Principles
1. ### Single Responsibility Principle (SRP)
    [Single Responsibility Principle (SRP)](https://github.com/mafsan786git/low-level-design-learning/blob/main/SolidPrinciples/SingleResponsibilityPrinciple#readme)

2. ### Open/Closed Principle (OCP)
    [Open/Closed Principle (OCP)](https://github.com/mafsan786git/low-level-design-learning/blob/main/SolidPrinciples/OpenClosedPrinciple#readme)

3. ### Liskov Substitution Principle (LSP)
    [Liskov Substitution Principle (LSP)](https://github.com/mafsan786git/low-level-design-learning/blob/main/SolidPrinciples/LiskovSubstitutionPrinciple#readme)

4. ### Interface Segregation Principle (ISP)
    [Interface Segregation Principle (ISP)](https://github.com/mafsan786git/low-level-design-learning/tree/main/SolidPrinciples/InterfaceSegregationPrinciple#readme)

5. ### Dependency Inversion Principle (DIP)
    [Dependency Inversion Principle (DIP)](https://github.com/mafsan786git/low-level-design-learning/tree/main/SolidPrinciples/DependencyInversionPrinciple#readme)


##$ Liskov(LSP) vs Interface (ISP)
Liskov Substitution Principle (LSP) and Interface Segregation Principle (ISP) are connected, 
as they both belong to the SOLID principles of object-oriented design, and they often complement each other in designing robust and maintainable systems. 

**Let’s break this down:**  
`Liskov Substitution Principle (LSP):`  
**The Liskov Substitution Principle states:**
"Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program."  

**This principle ensures that:**  
Subclasses or derived classes extend the behavior of the parent class without introducing unexpected behavior.
A subclass should honor the contract of its base class.

**Key Connection to Interfaces:**  
Subclasses often implement interfaces or abstract classes. If the subclass violates the expected behavior or contract of the interface, it breaks LSP.


`Interface Segregation Principle (ISP):`  
The Interface Segregation Principle states:
"A client should not be forced to implement an interface it does not use."  
This principle encourages creating smaller, more specific interfaces instead of large, general-purpose ones.


**Key Connection to LSP:**  
When designing systems that follow LSP, interfaces often play a crucial role.  
If an interface is too broad, subclasses might end up violating LSP because they’re forced to implement methods they don’t actually support or need
ISP helps prevent this by splitting large interfaces into smaller, role-specific ones, ensuring that each subclass implements only what is relevant.


**Summary**:  
LSP ensures subclasses behave as expected and adhere to their base class or interface contracts.  
ISP prevents the creation of overly large interfaces that force subclasses to implement irrelevant or unsupported methods.  
`Together, they ensure clean design:`
ISP creates focused, relevant interfaces.  
LSP ensures classes implementing those interfaces behave predictably and correctly.

