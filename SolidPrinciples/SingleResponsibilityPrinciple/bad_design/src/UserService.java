

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
