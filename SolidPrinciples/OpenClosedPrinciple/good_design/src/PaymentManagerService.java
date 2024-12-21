public class PaymentManagerService {
    private final PaymentProcessorFactory paymentProcessorFactory;

    public PaymentManagerService(PaymentProcessorFactory paymentProcessorFactory) {
        this.paymentProcessorFactory = paymentProcessorFactory;
    }


    public String processPayment(String details,PaymentType paymentType){
        PaymentProcessor paymentProcessor = paymentProcessorFactory.getPaymentProcessor(paymentType);
        return paymentProcessor.processPayment(details);
    }

}
