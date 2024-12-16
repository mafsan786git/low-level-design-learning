public class CartService {
    private final CreditCardPaymentGateway creditCardPaymentGateway;
    private final UPIPaymentGateway upiPaymentGateway;

    public CartService(CreditCardPaymentGateway creditCardPaymentGateway, UPIPaymentGateway upiPaymentGateway) {
        this.creditCardPaymentGateway = creditCardPaymentGateway;
        this.upiPaymentGateway = upiPaymentGateway;
    }

    public String processPayment(String paymentType){
        if(paymentType.equalsIgnoreCase("UPI")){
            return upiPaymentGateway.processPayment();
        }
        if (paymentType.equalsIgnoreCase("CREDIT_CARD")) {
            return creditCardPaymentGateway.processPayment();
        }
        throw new IllegalArgumentException("Unsupported payment type");
    }
}
