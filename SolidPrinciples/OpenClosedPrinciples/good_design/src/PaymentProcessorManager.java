public class PaymentProcessorManager {

    private final PaymentProcessor paymentProcessor;

    public PaymentProcessorManager(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }

    public String processPayment(){
        return paymentProcessor.processPayment();
    }
}
