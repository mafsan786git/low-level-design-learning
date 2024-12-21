import com.sun.jdi.request.InvalidRequestStateException;

public class UserManagerService {
    private final UserService userService;

    public UserManagerService(UserService userService) {
        this.userService = userService;
    }

    public String saveUser(UserDetails userDetails) {
        if (!userService.validateUserDetails(userDetails)) throw new InvalidRequestStateException("Invalid user details");
        if (!userService.isValidEmail(userDetails.getEmail())) throw new InvalidRequestStateException("Invalid user emailId");
        String saveUser = userService.saveUser(userDetails);
        userService.sendEmail(userDetails.getEmail(),"Test email");
        return saveUser;
    }
}
