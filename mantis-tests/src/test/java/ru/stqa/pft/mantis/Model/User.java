package ru.stqa.pft.mantis.Model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by SerejKa on 05.06.2017.
 */

@Entity
@Table(name = "mantis_user_table")
public class User {

    @Id
    @Column(name = "id")
    private  int id = Integer.MAX_VALUE;
    @Expose
    @Column (name = "username")
    @Type(type = "text")
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


