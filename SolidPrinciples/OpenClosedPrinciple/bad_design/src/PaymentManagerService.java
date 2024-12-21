public class PaymentManagerService {
    private final PaymentService paymentService;


    public PaymentManagerService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public String processPayment(String paymentType) {
        return paymentService.processPayment(paymentType);
    }
}
