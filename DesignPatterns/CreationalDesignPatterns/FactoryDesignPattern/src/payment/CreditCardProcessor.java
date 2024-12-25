package payment;

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
