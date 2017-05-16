package ru.stqa.pft.addressbook.model;

public class ContactFio {



    private  int id = Integer.MAX_VALUE;
    private  String name;
    private  String middlename;
    private  String lastname;
    private  String homePhone;
    private  String mobilePhone;
    private  String workPhone;
    private  String allPhones;

    public String getAllPhones() {
        return allPhones;
    }

    public ContactFio withAllPhones(String allPhones) {
        this.allPhones = allPhones;
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
