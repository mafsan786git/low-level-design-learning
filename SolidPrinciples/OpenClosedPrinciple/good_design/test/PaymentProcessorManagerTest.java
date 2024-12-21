import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentProcessorManagerTest {

    private PaymentManagerService paymentProcessorManager;

    @Before
    public void setUp() {
        paymentProcessorManager = new PaymentManagerService(new PaymentProcessorFactory());
    }

    @Test
    public void testProcessPaymentCreditCard() {
        String result = paymentProcessorManager.processPayment("Credit Card",PaymentType.CREDIT_CARD);
        assertEquals("Processing credit card", result);
    }

    @Test
    public void testProcessPaymentUPI() {
        String result = paymentProcessorManager.processPayment("UPI payment",PaymentType.UPI);
        assertEquals("Processing UPI payment", result);
    }

    @Test
    public void testProcessPaymentBankTransfer() {
        String result = paymentProcessorManager.processPayment("Bank transfer",PaymentType.BANK_TRANSFER);
        assertEquals("Processing Bank Transfer.", result);
    }
}
