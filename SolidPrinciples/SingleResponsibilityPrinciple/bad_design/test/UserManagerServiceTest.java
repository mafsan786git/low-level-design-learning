import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserManagerServiceTest {
    UserService userManager;
    @Before
    public void setUp() {
        // Initialize resources before each test case
        userManager = new UserService();
    }

    @Test
    public void testSaveUser(){
        UserDetails userDetails = new UserDetails("Bob","bob@gmail.com");
        String saveUser = userManager.saveUser(userDetails);
        boolean validEmail = userManager.isValidEmail(userDetails.getEmail());
        String testEmail = userManager.sendEmail(userDetails.getEmail(), "Test email");
        assertEquals(saveUser,"UserDetails saved : " + userDetails.getName());
        assertTrue(validEmail);
        assertEquals(testEmail,"Sending email to: " + userDetails.getEmail() + " message : " + "Test email");
    }

    @Test
    public void testSaveUserInValidEmail(){
        UserDetails userDetails = new UserDetails("Bob","bob@gmailcom");
        boolean validEmail = userManager.isValidEmail(userDetails.getEmail());
        assertFalse(validEmail);
    }
}
