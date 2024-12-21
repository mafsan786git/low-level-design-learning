public class CreditCardPaymentProcessor implements PaymentProcessor {

    @Override
    public String processPayment(String details) {
        return "Processing credit card";
    }
}
