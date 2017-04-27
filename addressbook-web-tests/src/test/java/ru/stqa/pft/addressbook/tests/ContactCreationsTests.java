package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

public class ContactCreationsTests extends TestBase{


    @Test
    public void testContactCreations() {

        app.getNavigationHelper().gotoPageContacts();

        app.getContactHelper().createContactFio(new ContactFio(null, null, "GFGHFGHFGHFH"));
        app.getContactHelper().createContactInformation(new ContactInformation("serejka_sm", "Title", "equifax"));
        app.getContactHelper().createContactPhone(new ContactAddressPhone("каланчевская плаза", "999-99-98889"));

        app.getNavigationHelper().submitData();
        app.getNavigationHelper().gotoPageHome();
        app.getNavigationHelper().logout();

    }


}
