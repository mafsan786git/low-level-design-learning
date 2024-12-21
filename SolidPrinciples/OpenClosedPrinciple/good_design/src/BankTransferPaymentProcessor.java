public class BankTransferPaymentProcessor implements PaymentProcessor {
    @Override
    public String processPayment(String details) {
        return "Processing Bank Transfer.";
    }


}
