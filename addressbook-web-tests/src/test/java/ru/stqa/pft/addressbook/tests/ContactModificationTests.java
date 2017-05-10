package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.Comparator;
import java.util.HashSet;
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
            app.getContactHelper().pushEdit(before.get(before.size() - 1).getId());
            ContactFio contact = new ContactFio(before.get(before.size() - 1).getId(),"ПОСЛЕДНИЙ7773333", "элемент333", "ЭЛЕМЕНТ");
            app.getContactHelper().fillContactFio(contact);
            app.getContactHelper().fillContactInformation(new ContactInformation("serejka_sm", "Title", "equifax"));
            app.getContactHelper().fillContactAddressPhone(new ContactAddressPhone("800000 kkkkkkkkk", "999-9999777-99"));
            app.getNavigationHelper().updateData();
            app.getNavigationHelper().gotoPageHome();
            List<ContactFio> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size());

            before.remove(before.size()-1);

            before.add(contact);
            Comparator<? super ContactFio> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before, after);

        }

}
