package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table (name = "addressbook")
public class ContactFio {

@Id
@Column (name = "id")
    private  int id = Integer.MAX_VALUE;
    @Expose
    @Column (name = "firstname")
    private  String name;
    @Expose
    @Column (name = "middlename")
    private  String middlename;
    @Expose
    @Column (name = "lastname")
    private  String lastname;
    @Expose
    @Column (name = "home")
    @Type(type = "text")
    private  String homePhone;
    @Expose
    @Column (name = "mobile")
    @Type(type = "text")
    private  String mobilePhone;
    @Expose
    @Column (name = "work")
    @Type(type = "text")
    private  String workPhone;
    @Transient
    private  String allPhones;
    @Expose
    @Column (name = "email")
    @Type(type = "text")
    private  String email;
    @Expose
    @Column (name = "email2")
    @Type(type = "text")
    private  String email2;
    @Expose
    @Column (name = "email3")
    @Type(type = "text")
    private  String email3;
    @Transient
    private  String allMails;
    @Expose
    @Column (name = "address")
    @Type(type = "text")
    private  String address;

    @Transient
    private String photo;

    @ManyToMany
    @JoinTable(name = "address_in_groups", joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private Set<GroupData> groups = new HashSet<>();

    public File getPhoto() {
        if (photo !=  null) {
            return new File(photo);
        } else {
            return null;
        }
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

    public Groups getGroups() {
        return new Groups(groups);
    }

    @Override
    public String toString() {
        return "ContactFio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", middlename='" + middlename + '\'' +
                ", lastname='" + lastname + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactFio that = (ContactFio) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (middlename != null ? !middlename.equals(that.middlename) : that.middlename != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;
        if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;
        if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
        return address != null ? address.equals(that.address) : that.address == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (middlename != null ? middlename.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (homePhone != null ? homePhone.hashCode() : 0);
        result = 31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
        result = 31 * result + (workPhone != null ? workPhone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    public ContactFio inGroup(GroupData group) {
        groups.add(group);
        return this;
    }
}
