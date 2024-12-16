
public class UserManagerServiceRefactor {
    private final EmailService emailService;
    private final UserRepository userRepository;
    private final UserValidation userValidation;

    public UserManagerServiceRefactor(EmailService emailService, UserRepository userRepository, UserValidation userValidation) {
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.userValidation = userValidation;
    }

    public String registerUsers(UserDetails userDetails){
        if (!userValidation.validateUserDetails(userDetails)) return "User validation failed";
        userRepository.saveUser(userDetails);
        emailService.sendEmail(userDetails.getEmail(),"Welcome to our website!");
        return "User successfully registered.";
    }
}
