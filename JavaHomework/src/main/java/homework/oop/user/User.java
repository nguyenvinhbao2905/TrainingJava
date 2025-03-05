package homework.oop.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class User {

    private String name;
    private String mail;
    private String password;
    protected List<Permission> permissions;


    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public enum Permission {
        MANAGE_PRODUCTS, MANAGE_ORDERS, PURCHASE_ITEMS, WRITE_REVIEWS;
    }


    public User(String name, String mail, String rawPassword) {
        this.name = name;
        this.mail = mail;
//        this.password = hashPassword(rawPassword);
        this.password = hashPasswordUserBCrypt(rawPassword);
        this.permissions = new ArrayList<>();
    }

    public User(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }
    public User(){}

    public String hashPassword(String rawPassword) {
        return encoder.encode(rawPassword);
    }
    public boolean checkPassword(String inputPassword) {
        return encoder.matches(inputPassword, this.password);
    }

    public String hashPasswordUserBCrypt(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
    }

    public boolean checkPassWordUseBCrypt(String inputPassword) {
        return BCrypt.checkpw(inputPassword, this.password);
    }

    public void displayUser() {
        System.out.println("Name: " + name);
        System.out.println("Mail: " + mail);
    }
    public void showPermissions() {
        System.out.println("Permissions:" + permissions);
    }

    public void login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = sc.nextLine();
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
    }

    public boolean checkPasswordInList(String password){
        return this.password.equals(password);
    }


}
