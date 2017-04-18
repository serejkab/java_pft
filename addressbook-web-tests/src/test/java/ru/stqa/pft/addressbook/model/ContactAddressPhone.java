package ru.stqa.pft.addressbook.model;

public class ContactAddressPhone {
    private final String street;
    private final String phone;

    public ContactAddressPhone(String street, String phone) {
        this.street = street;
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public String getPhone() {
        return phone;
    }
}
