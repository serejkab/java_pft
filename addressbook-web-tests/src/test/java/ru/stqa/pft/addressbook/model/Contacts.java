package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by SerejKa on 15.05.2017.
 */
public class Contacts extends ForwardingSet<ContactFio>{

    private Set<ContactFio> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<>();
    }

    public Contacts(Collection<ContactFio> contacts) {
        this.delegate = new HashSet<>(contacts);
    }


    @Override
    protected Set<ContactFio> delegate() {
        return delegate;
    }

    public Contacts withAdded(ContactFio contact){
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts without(ContactFio contact){
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
}

