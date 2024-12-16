import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CartServiceTest {

    CartService cartService;

    @Test
    public void testProcessPayment_UPI() {
        cartService = new CartService(new CreditCardPaymentGateway(), new UPIPaymentGateway());
        assertEquals("Processing UPI payment", cartService.processPayment("UPI"));
    }

    @Test
    public void testProcessPayment_CreditCard() {
        cartService = new CartService(new CreditCardPaymentGateway(), new UPIPaymentGateway());
        assertEquals("Processing Credit card payment", cartService.processPayment("CREDIT_CARD"));
    }
}
