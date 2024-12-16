public class CartService {
    private final PaymentGateway paymentGateway;

    public CartService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String processPayment(){
        return paymentGateway.processPayment();
    }
}
