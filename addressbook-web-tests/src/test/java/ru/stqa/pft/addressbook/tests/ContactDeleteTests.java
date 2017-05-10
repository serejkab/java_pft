package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.List;

/**
 * Created by SerejKa on 19.04.2017.
 */
public class ContactDeleteTests  extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
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

    }

    @Test
    public void testContactDeletion(){

        List<ContactFio> before = app.getContactHelper().getContactList();
        int index = before.size() - 1;
        app.getContactHelper().selectContact(index);
        app.getContactHelper().pushDeleteContact();
        app.getContactHelper().alertAccept();
        app.getNavigationHelper().gotoPageHome();
        List<ContactFio> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(before,after);

    }

}
