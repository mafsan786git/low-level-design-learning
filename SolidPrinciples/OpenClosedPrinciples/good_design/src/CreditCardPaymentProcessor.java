public class CreditCardPaymentProcessor implements PaymentProcessor {

    @Override
    public String processPayment() {
        return "Processing credit card";
    }
}
