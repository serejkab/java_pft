package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

public class ContactCreationsTests extends TestBase{


    @Test
    public void testContactCreations() {

        app.gotoPageContacts();
        app.getContactHelper().fillContactFio(new ContactFio("Sergey", "Test2", "Babakhin"));
        app.getContactHelper().fillContactInformation(new ContactInformation("serejka_sm", "Title", "equifax"));
        app.getContactHelper().fillContactAddressPhone(new ContactAddressPhone("каланчевская плаза", "999-99-99"));
        app.submitData();
        app.gotoPageHome();
        app.logout();

    }


}
