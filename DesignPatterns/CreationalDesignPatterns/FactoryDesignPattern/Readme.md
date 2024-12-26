### Factory Design Pattern
Factory Design Pattern, which is one of the most commonly used design patterns. The Factory pattern provides a way to 
create objects without explicitly specifying their exact classes, promoting loose coupling and flexibility.

**Key Benefits of Factory Pattern:**
1. `Encapsulation:`
    1. Object creation logic is encapsulated in the factory
    2. Client code doesn't need to know the concrete classes 
2. `Loose Coupling:`
   1. Client code depends on interfaces rather than concrete classes 
   2. Easy to add new product types without changing existing code
3. `Single Responsibility:`
   1. Object creation is handled by factories 
   2. Each factory is responsible for creating one type of object
4. `Open/Closed Principle:`
   1. New product types can be added without modifying existing code 
   2. Just create new concrete classes and corresponding factories
5. Flexibility in adding new types without changing existing code

**Common Use Cases:**
* Database connections
* Payment processing systems
* UI component creation
* Logging frameworks
* Document generators

 **When to Use Factory Pattern in Java:**  
* When you need to create objects without specifying their concrete classes.
* When the exact class of an object is determined at runtime.
* When the object creation involves complex logic that you want to centralize.


```java
// Payment interface
public interface PaymentProcessor {
    void processPayment(double amount);
    boolean validatePayment();
}
----------------------------
// Concrete payment processors
public class CreditCardProcessor implements PaymentProcessor {
    private String cardNumber;
    private String cvv;

    public CreditCardProcessor(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    public void processPayment(double amount) {
        if (validatePayment()) {
            System.out.println("Processing credit card payment of $" + amount);
        }
    }

    @Override
    public boolean validatePayment() {
        // Add credit card validation logic
        return cardNumber != null &&
                !cardNumber.isEmpty() &&
                cvv != null &&
                !cvv.isEmpty();
    }
}
----------------------------
// Concrete payment processors
public class PayPalProcessor implements PaymentProcessor {
    private String email;

    public PayPalProcessor(String email) {
        this.email = email;
    }

    @Override
    public void processPayment(double amount) {
        if (validatePayment()) {
            System.out.println("Processing PayPal payment of $" + amount);
        }
    }

    @Override
    public boolean validatePayment() {
        // Add PayPal validation logic
        return email != null && !email.isEmpty();
    }
}
----------------------------
----------------------------
// Abstract factory

public abstract class PaymentProcessorFactory {
    abstract PaymentProcessor createPaymentProcessor();

    public void processPayment(double amount){
        PaymentProcessor paymentProcessor = createPaymentProcessor();
        if (paymentProcessor.validatePayment()){
            paymentProcessor.processPayment(amount);
        }else {
            System.out.println("Payment validation failed");
        }

    }
}
----------------------------

// Concrete factories
public class CreditCardProcessorFactory extends PaymentProcessorFactory {
    private String cardNumber;
    private String cvv;

    public CreditCardProcessorFactory(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    PaymentProcessor createPaymentProcessor() {
        return new CreditCardProcessor(cardNumber, cvv);
    }
}
----------------------------

public class PayPalProcessorFactory extends PaymentProcessorFactory {
    private String email;

    public PayPalProcessorFactory(String email) {
        this.email = email;
    }
    @Override
    PaymentProcessor createPaymentProcessor() {
        return new PayPalProcessor(email);
    }

}
----------------------------
----------------------------


//Main Test
public class Main {
    public static void main(String[] args) {
        // Process credit card payment
        PaymentProcessorFactory creditCardFactory = new CreditCardProcessorFactory("1234-5678-9012-3456", "123");
        creditCardFactory.processPayment(100.00);

        // Process PayPal payment
        PaymentProcessorFactory paypalFactory = new PayPalProcessorFactory("user@example.com");
        paypalFactory.processPayment(50.00);
    }
}

```
