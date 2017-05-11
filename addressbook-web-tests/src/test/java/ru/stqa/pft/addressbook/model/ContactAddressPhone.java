package ru.stqa.pft.addressbook.model;

public class ContactAddressPhone {
    private  String street;
    private  String phone;



    public ContactAddressPhone withStreet(String street) {
        this.street = street;
        return this;
    }

    public ContactAddressPhone withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public String getPhone() {
        return phone;
    }
}
