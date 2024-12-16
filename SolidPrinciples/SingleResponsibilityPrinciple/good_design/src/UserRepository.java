
public class UserRepository {
    public void saveUser(UserDetails userDetails){
        //Database operations here
        System.out.println("UserDetails saved : " + userDetails.getName());
    }
}
