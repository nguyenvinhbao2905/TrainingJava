package homework.collection.user;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;

@Setter
@Getter
public class UserRegistry {
    private HashSet<User> users;


    public UserRegistry() {
        users = new HashSet<>();
    }

    public void checkEmail(String email) {
        boolean exists = users.contains(new User(email));
        if (exists) {
            System.out.println("Email is existed");
        } else {
            System.out.println("Email is not existed");
        }
    }
    public boolean addUser(User user) {
        return users.add(user);
    }
}
