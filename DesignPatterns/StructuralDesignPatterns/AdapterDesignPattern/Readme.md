### Adapter Design Pattern
The Adapter Design Pattern allows two incompatible interfaces to work together by converting the interface of one class into another interface that a client expects. 
It acts as a bridge between two otherwise incompatible systems.

**Key Components :**
1. `Target Interface :` Defines the interface that the client expects.
2. `Client :` The code or class that interacts with the target interface.
3. `Adaptee :` The existing interface that needs to be adapted to the target interface.
4. `Adapter :` A class that implements the target interface and translates the requests to the adaptee.

**Types of Adapters :**
1. `Class Adapter:`  
   Uses inheritance to adapt the Adaptee to the Target interface.
   Works only in languages that support multiple inheritance (e.g., C++).
2. `Object Adapter:`  
   Uses composition to adapt the Adaptee to the Target interface.
   More flexible because it works with any Adaptee instance.

**When to Use the Adapter Pattern :**
1. When you want to use an existing class but its interface does not match the one you need.
2. When you need to integrate third-party libraries into your system.
3. When migrating legacy code to a new system without rewriting the existing implementation.

**Advantages :** 
1. `Flexibility:` Allows the reuse of existing code without modification.
2. `Decoupling:` The client is decoupled from the Adaptee's implementation.
3. `Single Responsibility Principle:` Keeps the conversion logic separate from both the client and adaptee.

**Real-World Examples :**
1. `Media Player Software:` Adapting various audio or video formats to a single media player interface.
2. `Payment Gateways:` Converting multiple third-party payment APIs into a common interface for the client application.

```java
//Java code available in src file
```

