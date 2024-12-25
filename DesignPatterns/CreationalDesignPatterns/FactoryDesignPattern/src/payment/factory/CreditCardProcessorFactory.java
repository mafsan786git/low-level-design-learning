package payment.factory;

import payment.CreditCardProcessor;
import payment.PaymentProcessor;

// Concrete factories
public class CreditCardProcessorFactory extends PaymentProcessorFactory {
    private String cardNumber;
    private String cvv;

    public CreditCardProcessorFactory(String cardNumber, String cvv) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
    }

    @Override
    PaymentProcessor createPaymentProcessor() {
        return new CreditCardProcessor(cardNumber, cvv);
    }
}

