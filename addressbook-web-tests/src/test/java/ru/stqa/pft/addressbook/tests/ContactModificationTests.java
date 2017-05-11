package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.Comparator;
import java.util.List;

/**
 * Created by SerejKa on 19.04.2017.
 */
public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){

        app.goTo().pageHome();
        if(app.contact().list().size() == 0)
        {
            app.goTo().gotoPageContacts();
            app.contact().createContactFio(new ContactFio().withName("fddgdfg").withMiddlename("dssdf").withLastname("sdfsdf"));
            app.contact().createContactInformation(new ContactInformation().withNickname("serejka_sm").withTitle("Title").withCompany("equifax"));
            app.contact().createContactPhone(new ContactAddressPhone().withStreet("каланчевская плаза").withPhone("999-99-98889"));
            app.goTo().submitData();
            app.goTo().pageHome();
        }

    }

        @Test
        public void testContactModification(){

            List<ContactFio> before = app.contact().list();
            int index = before.size() - 1;
            app.contact().selectContact(index);
            app.contact().pushEdit(before.get(index).getId());
            ContactFio contact = new ContactFio().withId(before.get(index).getId()).withName("fddgdfg").withMiddlename("dssdf").withLastname("sdfsdf");
            app.contact().fillContactFio(contact);
            app.contact().fillContactInformation(new ContactInformation().withNickname("serejka_sm").withTitle("Title").withCompany("equifax"));
            app.contact().fillContactAddressPhone(new ContactAddressPhone().withStreet("каланчевская плаза").withPhone("999-99-98889"));
            app.goTo().updateData();
            app.goTo().pageHome();
            List<ContactFio> after = app.contact().list();
            Assert.assertEquals(after.size(), before.size());

            before.remove(index);

            before.add(contact);
            Comparator<? super ContactFio> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before, after);

        }

}
