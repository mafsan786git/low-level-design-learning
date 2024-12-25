package payment.factory;

import payment.PaymentProcessor;

public abstract class PaymentProcessorFactory {
    abstract PaymentProcessor createPaymentProcessor();

    public void processPayment(double amount){
        PaymentProcessor paymentProcessor = createPaymentProcessor();
        if (paymentProcessor.validatePayment()){
            paymentProcessor.processPayment(amount);
        }else {
            System.out.println("Payment validation failed");
        }

    }
}
