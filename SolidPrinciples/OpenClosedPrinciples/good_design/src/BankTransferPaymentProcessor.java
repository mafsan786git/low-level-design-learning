public class BankTransferPaymentProcessor implements PaymentProcessor {
    @Override
    public String processPayment() {
        return "Processing Bank Transfer.";
    }
}
