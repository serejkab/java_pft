package ru.stqa.pft.mantis.Model;

/**
 * Created by SerejKa on 05.06.2017.
 */
public class User {

    private  int id = Integer.MAX_VALUE;
    private String username;

    public int getId() {
        return id;
    }

    public User withId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User withUsername(String username) {
        this.username = username;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }
}


