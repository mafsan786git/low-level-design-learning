# Open/Closed Principle (OCP)

Definition:  
A class, module, or function should be open for extension but closed for modification. This means you should be able to add new functionality to an existing codebase without altering the existing, stable code. This is typically achieved using abstraction (e.g., interfaces or inheritance) and polymorphism.

Bad Code (Violating OCP):
```java
public class PaymentService {

    public void processPayment(String paymentType) {
        if (paymentType.equals("CREDIT_CARD")) {
            // Process credit card payment
            System.out.println("Processing credit card payment...");
        } else if (paymentType.equals("UPI")) {
            // Process PayPal payment
            System.out.println("Processing PayPal payment...");
        } else {
            throw new IllegalArgumentException("Unsupported payment type");
        }
    }
}
```
What’s wrong here?  
Violation of OCP:  
Adding a new payment type requires modifying the processPayment method. For example, if you want to add Bank Transfer, you need to modify the if-else block.
This approach makes the code harder to maintain and test, increasing the risk of introducing bugs in existing logic.
Tightly Coupled: The logic for handling payment types is hardcoded into the PaymentService class, making it less flexible.

GOOD Code (Adhering to OCP): 
```java
//interface
public interface PaymentProcessor {
    String processPayment();
}

//CreditCard implementation
public class CreditCardPaymentProcessor implements PaymentProcessor {

    @Override
    public String processPayment() {
        return "Processing credit card";
    }
}


//UPI implementation
public class UpiPaymentProcessor implements PaymentProcessor {

    @Override
    public String processPayment() {
        return "Processing UPI payment";
    }
}


//Payment Process Manager
public class PaymentProcessorManager {

    private final PaymentProcessor paymentProcessor;

    public PaymentProcessorManager(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }

    public String processPayment(){
        return paymentProcessor.processPayment();
    }
}

```

Add a New Payment Type : 
Just adding `BankTransferPaymentProcessor` , client can send as BankTransferPaymentProcessor object, no change
required in any of core logic.
```java
public class BankTransferPaymentProcessor implements PaymentProcessor {
    @Override
    public String processPayment() {
        return "Processing Bank Transfer.";
    }
}
```

To make this more usable we can apply strategy pattern.

Explanation of Improvements:  
1. **Open for Extension**: To add a new payment type, you simply create a new class that implements the PaymentProcessor interface (e.g., UPIPaymentProcessor) without modifying existing code. 
2. **Closed for Modification**: The existing PaymentService class does not need to be changed when introducing new payment methods. 
3. **Loose Coupling**: The PaymentService relies on the PaymentProcessor abstraction, making the system more modular and extensible.


Key Advantages:  
1. **Extensibility**: Adding new payment types or functionalities doesn’t require modifying the existing PaymentService, reducing the risk of bugs. 
2. **Maintainability**: The system becomes easier to maintain because logic is decoupled and distributed across smaller, focused classes. 
3. **Testability**: Each payment processor can be unit tested independently, and the PaymentService can be tested with mocks.


**Conclusion**:  
**_Bad Code_**: Hardcoding payment types and logic in a single class violates OCP, leading to tight coupling and high maintenance costs.  
**_Good Code_**: By relying on abstractions and leveraging polymorphism, the system becomes flexible, extensible, and adheres to the Open/Closed Principle.
