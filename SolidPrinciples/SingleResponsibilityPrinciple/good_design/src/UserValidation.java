
public class UserValidation {
    private final EmailValidation emailValidation;
    public UserValidation(EmailValidation emailValidation) {
        this.emailValidation = emailValidation;
    }

    public boolean validateUserDetails(UserDetails userDetails){
        return userDetails.getName() != null && emailValidation.isValidEmail(userDetails.getEmail());
    }
}
