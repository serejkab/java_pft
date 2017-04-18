package ru.stqa.pft.addressbook;


import org.testng.annotations.Test;

public class ContactCreationsTests extends TestBase{


    @Test
    public void testContactCreations() {

        gotoPageContacts();
        fillContactFio(new ContactFio("Sergey", "Test2", "Babakhin"));
        fillContactInformation(new ContactInformation("serejka_sm", "Title", "equifax"));
        fillContactAddressPhone(new ContactAddressPhone("каланчевская плаза", "999-99-99"));
        submitData();
        gotoPageHome();
        logout();

    }


}
