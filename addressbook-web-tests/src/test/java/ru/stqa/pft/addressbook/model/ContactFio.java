package ru.stqa.pft.addressbook.model;

public class ContactFio {



    private  int id;
    private final String name;
    private final String middlename;
    private final String lastname;

    public ContactFio(String name, String middlename, String lastname) {
        this.id = 0;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
    }


    public ContactFio(int id, String name, String middlename, String lastname) {
        this.id = id;
        this.name = name;
        this.middlename = middlename;
        this.lastname = lastname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
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

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }
}
