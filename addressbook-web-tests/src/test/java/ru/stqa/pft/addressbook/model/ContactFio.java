package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;


@Entity
@Table (name = "addressbook")
public class ContactFio {

@Id
@Column (name = "id")
    private  int id = Integer.MAX_VALUE;
    @Expose
    @Column (name = "firstname")
    private  String name;
    @Column (name = "middlename")
    private  String middlename;
    @Expose
    @Column (name = "lastname")
    private  String lastname;
    @Expose
    @Column (name = "home")
    @Type(type = "text")
    private  String homePhone;
    @Column (name = "mobile")
    @Type(type = "text")
    private  String mobilePhone;
    @Column (name = "work")
    @Type(type = "text")
    private  String workPhone;
    @Transient
    private  String allPhones;
    @Expose
    @Column (name = "email")
    @Type(type = "text")
    private  String email;
    @Column (name = "email2")
    @Type(type = "text")
    private  String email2;
    @Column (name = "email3")
    @Type(type = "text")
    private  String email3;
    @Transient
    private  String allMails;
    @Expose
    @Column (name = "address")
    @Type(type = "text")
    private  String address;
    @Column (name = "photo")
    @Type(type = "text")
    private String photo;


    public File getPhoto() {
        return new File(photo);
    }

    public ContactFio withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactFio withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public ContactFio withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAllMails() {
        return allMails;
    }

    public ContactFio withAllMails(String allMails) {
        this.allMails = allMails;
        return this;
    }

    public ContactFio withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }


    public ContactFio withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public ContactFio withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactFio withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public ContactFio withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactFio withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public ContactFio withId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {return id;}

    public String getName() {
        return name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public ContactFio withName(String name) {
        this.name = name;
        return this;
    }

    public ContactFio withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactFio withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    @Override
    public String toString() {
        return "ContactFio{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactFio that = (ContactFio) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}
