package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

/**
 * Created by SerejKa on 19.04.2017.
 */
public class ContactDeleteTests  extends TestBase{

    @Test
    public void testContactDeletion(){

        app.getNavigationHelper().gotoPageHome();

        if(!app.getContactHelper().isThereAContact())
        {
            app.getNavigationHelper().gotoPageContacts();
            app.getContactHelper().createContactFio(new ContactFio("dsfdsf", "sdfsdf", "dfgdfgdfg"));
            app.getContactHelper().createContactInformation(new ContactInformation("serejka_sm", "Title", "equifax"));
            app.getContactHelper().createContactPhone(new ContactAddressPhone("каланчевская плаза", "999-99-98889"));
            app.getNavigationHelper().submitData();
            app.getNavigationHelper().gotoPageHome();
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().pushDeleteContact();
        app.getContactHelper().alertAccept();
        app.getNavigationHelper().gotoPageHome();

    }

}
