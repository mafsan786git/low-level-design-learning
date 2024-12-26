package payment.factory;

import payment.PayPalProcessor;
import payment.PaymentProcessor;

public class PayPalProcessorFactory extends PaymentProcessorFactory {
    private String email;

    public PayPalProcessorFactory(String email) {
        this.email = email;
    }
    @Override
    PaymentProcessor createPaymentProcessor() {
        return new PayPalProcessor(email);
    }

}

