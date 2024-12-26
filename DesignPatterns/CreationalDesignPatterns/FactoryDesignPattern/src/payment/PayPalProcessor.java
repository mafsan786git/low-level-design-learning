package payment;

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
