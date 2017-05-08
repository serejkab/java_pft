package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.List;

/**
 * Created by SerejKa on 19.04.2017.
 */
public class ContactModificationTests extends TestBase{

        @Test
        public void testContactModification(){


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
            List<ContactFio> before = app.getContactHelper().getContactList();
            app.getContactHelper().selectContact(before.size()-1);
            app.getContactHelper().pushEdit();
            app.getContactHelper().fillContactFio(new ContactFio("МИНУССС", "элемент", "Элемент -4"));
            app.getContactHelper().fillContactInformation(new ContactInformation("serejka_sm", "Title", "equifax"));
            app.getContactHelper().fillContactAddressPhone(new ContactAddressPhone("800000 kkkkkkkkk", "999-9999777-99"));
            app.getNavigationHelper().updateData();
            app.getNavigationHelper().gotoPageHome();
            List<ContactFio> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size());

        }

}
