public class PaymentService {

    public void processPayment(String paymentType) {
        if (paymentType.equals("CREDIT_CARD")) {
            // Process credit card payment
            System.out.println("Processing credit card payment...");
        } else if (paymentType.equals("PAYPAL")) {
            // Process PayPal payment
            System.out.println("Processing PayPal payment...");
        } else {
            throw new IllegalArgumentException("Unsupported payment type");
        }
    }
}
