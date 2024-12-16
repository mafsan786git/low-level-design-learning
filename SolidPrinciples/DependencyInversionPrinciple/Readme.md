# Dependency Inversion Principle (DIP)
Definition:  
The Dependency Inversion Principle (DIP) states that high-level modules should not depend on low-level modules. Instead, both should depend on abstractions. Furthermore, 
abstractions should not depend on details; details should depend on abstractions. This principle helps to decouple high-level and low-level modules, 
leading to more maintainable and testable code.

Bad Code (Violating DIP):
```java
public class CartService {
    private final CreditCardPaymentGateway creditCardPaymentGateway;
    private final UPIPaymentGateway upiPaymentGateway;

    public CartService(CreditCardPaymentGateway creditCardPaymentGateway, UPIPaymentGateway upiPaymentGateway) {
        this.creditCardPaymentGateway = creditCardPaymentGateway;
        this.upiPaymentGateway = upiPaymentGateway;
    }

    public String processPayment(String paymentType){
        if(paymentType.equalsIgnoreCase("UPI")){
            return upiPaymentGateway.processPayment();
        }
        if (paymentType.equalsIgnoreCase("CREDIT_CARD")) {
            return creditCardPaymentGateway.processPayment();
        }
        throw new IllegalArgumentException("Unsupported payment type");
    }
}

public class UPIPaymentGateway {
    public String processPayment() {
        return "Processing UPI payment";
    }
}

public class CreditCardPaymentGateway {
    public String processPayment() {
        return "Processing Credit card payment";
    }
}
```
In above code, `CartService` has concrete payment implementations, this way we have to pass new one then we need to add in constructor.
Violation of DIP:   
CartService directly depends on PaymentGateway. If we want to add a new gateway (e.g., PayPal, Bank Transfer), we need to modify CartService.
Tight Coupling: The system is inflexible and hard to maintain.


Good Code (Adhering to DIP):
```java
public class CartService {
    private final PaymentGateway paymentGateway;

    public CartService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String processPayment(){
        return paymentGateway.processPayment();
    }
}

public interface PaymentGateway {
    String processPayment();
}

public class CreditCardPaymentGateway implements PaymentGateway {
    @Override
    public String processPayment() {
        return "Processing Credit card payment";
    }
}


public class UPIPaymentGateway implements PaymentGateway {
    @Override
    public String processPayment() {
        return "Processing UPI payment";
    }
}
```
**Benefits:**  
1. `Decoupling`: CartService can now work with any PaymentGateway implementation.
2. `Scalability`: Adding a new payment method (like BankTransferPaymentGateway) requires no changes to CartService.
3. `Testability`: Test CartService with different PaymentGateway implementations easily.


**Conclusion:** 
1. `Bad Code`: Direct dependencies create tight coupling and inflexibility.
2. `Good Code`: By using abstractions (PaymentGateway), we achieve decoupling, flexibility, and testability—key benefits of adhering to the Dependency Inversion Principle (DIP).
