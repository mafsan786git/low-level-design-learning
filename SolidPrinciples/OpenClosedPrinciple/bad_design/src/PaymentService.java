public class PaymentService {

    public String processPayment(String paymentType) {
        if (paymentType.equals("CREDIT_CARD")) {
            // Process credit card payment
            return "Processing credit card payment...";
        } else if (paymentType.equals("PAYPAL")) {
            // Process PayPal payment
            return "Processing PayPal payment...";
        } else {
            throw new IllegalArgumentException("Unsupported payment type");
        }
    }
}
