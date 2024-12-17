# S - Single Responsibility Principle (SRP)
Definition: A class should have only one reason to change.

Explanation: Each class should focus on a single functionality or responsibility. If a class has multiple responsibilities, it can lead to tightly coupled code and make modifications risky.

Example: Instead of creating a UserManager class that handles validation user data, sending email, separate these into UserService, EmailService, and Validation.

Please look at the following code :
**Bad Design**
```java
public class UserManagerService {

    public void saveUser(UserDetails userDetails){
        System.out.println("UserDetails saved : " + userDetails.getName());
    }

    public  boolean isValidEmail(String email){
        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern patternRgx = java.util.regex.Pattern.compile(emailPattern);
        java.util.regex.Matcher matcherRgx = patternRgx.matcher(email);
        return matcherRgx.matches();
    }

    public void sendEmail(String email,String message){
        System.out.println("Sending email to: " + email + " message : " + message);
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
