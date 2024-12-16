import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CartServiceTest {
    CartService cartService;
    @Test
    public void testProcessCreditCardPayment() {
        cartService = new CartService(new CreditCardPaymentGateway());
        assertEquals("Processing Credit card payment", cartService.processPayment());
    }

    @Test
    public void testProcessUPIPayment() {
        cartService = new CartService(new UPIPaymentGateway());
        assertEquals("Processing UPI payment", cartService.processPayment());
    }
}
