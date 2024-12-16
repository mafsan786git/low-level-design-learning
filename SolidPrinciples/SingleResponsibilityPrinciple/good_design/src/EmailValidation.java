public class EmailValidation {
    public  boolean isValidEmail(String email){
        if (email == null ) return false;
        String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern patternRgx = java.util.regex.Pattern.compile(emailPattern);
        java.util.regex.Matcher matcherRgx = patternRgx.matcher(email);
        return matcherRgx.matches();
    }
}
