# S - Single Responsibility Principle (SRP)
Definition: A class should have only one reason to change.

Explanation: Each class should focus on a single functionality or responsibility. If a class has multiple responsibilities, it can lead to tightly coupled code and make modifications risky.

Example: Instead of creating a UserManager class that handles validation user data, sending email, separate these into UserService, EmailService, and Validation.

Please look at the following code :
**Bad Design**
```java
public class UserService {
    
    public String saveUser(UserDetails userDetails){
        return "UserDetails saved : " + userDetails.getName();
    }

    public boolean validateUserDetails(UserDetails userDetails){
        return userDetails != null && userDetails.getName() != null && userDetails.getEmail() != null;
    }

    public  boolean isValidEmail(String email){
        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern patternRgx = java.util.regex.Pattern.compile(emailPattern);
        java.util.regex.Matcher matcherRgx = patternRgx.matcher(email);
        return matcherRgx.matches();
    }

    public String sendEmail(String email,String message){
        return "Sending email to: " + email + " message : " + message;
    }
}

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
```

After refactoring

Please look at the following code :
**Good Design**
```java
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

public class UserRepository {
    public void saveUser(UserDetails userDetails){
        //Database operations here
        System.out.println("UserDetails saved : " + userDetails.getName());
    }
}

public class UserValidation {
    private final EmailValidation emailValidation;
    public UserValidation(EmailValidation emailValidation) {
        this.emailValidation = emailValidation;
    }

    public boolean validateUserDetails(UserDetails userDetails){
        return userDetails.getName() != null && emailValidation.isValidEmail(userDetails.getEmail());
    }
}


public class EmailValidation {
    public  boolean isValidEmail(String email){
        if (email == null ) return false;
        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern patternRgx = java.util.regex.Pattern.compile(emailPattern);
        java.util.regex.Matcher matcherRgx = patternRgx.matcher(email);
        return matcherRgx.matches();
    }
}

public class EmailService {

    public void sendEmail(String email,String message){
        System.out.println("Sending email to: " + email + " message : " + message);
    }

}

```
