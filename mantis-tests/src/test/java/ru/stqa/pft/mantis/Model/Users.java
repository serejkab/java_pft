package ru.stqa.pft.mantis.Model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by SerejKa on 05.06.2017.
 */
public class Users extends ForwardingSet<User>{

    private Set<User> delegate;

    public Users(Users users) {
        this.delegate = new HashSet<>(users.delegate);
    }

    public Users() {
        this.delegate = new HashSet<>();
    }

    public Users(Collection<User> users) {
        this.delegate = new HashSet<>(users);
    }

    @Override
    protected Set<User> delegate() {
        return delegate;
    }

    public Users withAdded(User user){
        Users users = new Users(this);
        users.add(user);
        return users;
    }

    public Users without(User contact){
        Users users = new Users(this);
        users.remove(contact);
        return users;
    }

}
