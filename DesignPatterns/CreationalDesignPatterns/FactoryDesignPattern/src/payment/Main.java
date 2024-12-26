package payment;

import payment.factory.CreditCardProcessorFactory;
import payment.factory.PayPalProcessorFactory;
import payment.factory.PaymentProcessorFactory;

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
