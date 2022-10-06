package helpers;

import java.io.Serializable;

public class User implements Serializable {
    String name;
    String email;
    String password;
    int score;

    public User(String email, String password) {
        this.name = "";
        this.email = email;
        this.password = password;
        score = 0;
    }

    public User(String name, String email, String password) {
        this(email, password);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
