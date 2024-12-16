import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailValidationTest {
    @Test
    public void testValidEmail() {
        EmailValidation emailValidation = new EmailValidation();
        assertTrue(emailValidation.isValidEmail("example@example.com"));
    }

    @Test
    public void testValidEmailInvalid() {
        EmailValidation emailValidation = new EmailValidation();
        assertFalse(emailValidation.isValidEmail("example.com"));
    }
}
