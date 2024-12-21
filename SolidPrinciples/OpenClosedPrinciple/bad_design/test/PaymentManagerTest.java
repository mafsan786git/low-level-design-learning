import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class PaymentManagerTest {
    PaymentManagerService paymentManagerService;
    @Before
    public void setUp() {
        paymentManagerService = new PaymentManagerService(new PaymentService());
        // Initialize resources before each test case
    }

    @Test
    public void testProcessCreditCard() {
        assertEquals("Processing credit card payment...", paymentManagerService.processPayment("CREDIT_CARD"));
    }

    @Test
    public void testProcessPaypal() {
        assertEquals("Processing PayPal payment...", paymentManagerService.processPayment("PAYPAL"));
    }

    @Test
    public void testProcessUnsupported() {
        assertThrows(IllegalArgumentException.class,()->paymentManagerService.processPayment("UPI"));
    }
}
