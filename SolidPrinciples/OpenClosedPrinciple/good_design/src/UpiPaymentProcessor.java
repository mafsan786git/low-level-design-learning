public class UpiPaymentProcessor implements PaymentProcessor {

    @Override
    public String processPayment(String details) {
        return "Processing UPI payment";
    }
}
