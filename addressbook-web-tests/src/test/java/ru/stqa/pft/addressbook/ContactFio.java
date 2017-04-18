package ru.stqa.pft.addressbook;

public class ContactFio {
    private final String name;
    private final String middlename;
    private final String lastname;

    public ContactFio(String name, String middlename, String lastname) {
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }
}
