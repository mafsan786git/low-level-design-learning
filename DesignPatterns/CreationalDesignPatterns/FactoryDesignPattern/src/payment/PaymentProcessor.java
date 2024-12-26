package payment;

public interface PaymentProcessor {
    void processPayment(double amount);
    boolean validatePayment();
}
