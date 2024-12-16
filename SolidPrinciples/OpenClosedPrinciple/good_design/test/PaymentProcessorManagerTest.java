import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentProcessorManagerTest {

    private PaymentProcessorManager paymentProcessorManager;

    @Test
    public void testProcessPaymentCreditCard() {
        paymentProcessorManager = new PaymentProcessorManager(new CreditCardPaymentProcessor());
        String result = paymentProcessorManager.processPayment();
        assertEquals("Processing credit card", result);
    }

    @Test
    public void testProcessPaymentUPI() {
        paymentProcessorManager = new PaymentProcessorManager(new UpiPaymentProcessor());
        String result = paymentProcessorManager.processPayment();
        assertEquals("Processing UPI payment", result);
    }

    @Test
    public void testProcessPaymentBankTransfer() {
        paymentProcessorManager = new PaymentProcessorManager(new BankTransferPaymentProcessor());
        String result = paymentProcessorManager.processPayment();
        assertEquals("Processing Bank Transfer.", result);
    }
}
