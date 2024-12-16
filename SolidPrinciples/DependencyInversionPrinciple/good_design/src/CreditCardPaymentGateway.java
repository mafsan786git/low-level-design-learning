public class CreditCardPaymentGateway implements PaymentGateway {
    @Override
    public String processPayment() {
        return "Processing Credit card payment";
    }
}
