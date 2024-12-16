import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserManagerRefactorTest {
    private UserManagerServiceRefactor userManagerServiceRefactor;

    @Before
    public void setUp() {
        // Initialize resources before each test case
        UserValidation userValidation = new UserValidation(new EmailValidation());
        EmailService emailService = new EmailService();
        UserRepository userRepository = new UserRepository();
        userManagerServiceRefactor = new UserManagerServiceRefactor(emailService, userRepository,userValidation);
    }

    @Test
    public void saveUserTest(){
        UserDetails userDetailsGood = new UserDetails("Bob","bob@gmail.com");
        String registerUsers = userManagerServiceRefactor.registerUsers(userDetailsGood);
        assertEquals(registerUsers, "User successfully registered.");
    }

    @Test
    public void saveUserWithInvalidEmailTest(){
        UserDetails userDetailsGood2 = new UserDetails("Bob","bob@gmailcom");
        String registerUsers = userManagerServiceRefactor.registerUsers(userDetailsGood2);
        assertEquals(registerUsers, "User validation failed");
    }

}
