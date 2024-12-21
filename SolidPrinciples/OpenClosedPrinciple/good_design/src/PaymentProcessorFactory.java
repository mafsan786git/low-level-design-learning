import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PaymentProcessorFactory {

    private final Map<PaymentType, PaymentProcessor> map;

    public PaymentProcessorFactory() {
        this.map = new HashMap<>();
    }

    public synchronized PaymentProcessor getPaymentProcessor(PaymentType paymentType) {
        return map.computeIfAbsent(paymentType, this::createPaymentProcessor);
    }

    private PaymentProcessor createPaymentProcessor(PaymentType paymentType) {
        return switch (paymentType) {
            case CREDIT_CARD -> new CreditCardPaymentProcessor();
            case UPI -> new UpiPaymentProcessor();
            case BANK_TRANSFER -> new BankTransferPaymentProcessor();
            default -> throw new IllegalArgumentException("Unsupported payment type: " + paymentType);
        };
    }
}
