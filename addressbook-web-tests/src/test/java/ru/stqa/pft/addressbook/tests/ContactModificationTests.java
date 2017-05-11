package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by SerejKa on 19.04.2017.
 */
public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){

        app.goTo().pageHome();
        if(app.contact().all().size() == 0)
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

            Set<ContactFio> before = app.contact().all();
            ContactFio modifiedContact = before.iterator().next();
            app.contact().selectContactById(modifiedContact.getId());
            app.contact().pushEdit(modifiedContact.getId());
            ContactFio contact = new ContactFio().withId(modifiedContact.getId()).withName("fddgdfg").withMiddlename("dssdf").withLastname("sdfsdf");
            app.contact().fillContactFio(contact);
            app.contact().fillContactInformation(new ContactInformation().withNickname("serejka_sm").withTitle("Title").withCompany("equifax"));
            app.contact().fillContactAddressPhone(new ContactAddressPhone().withStreet("каланчевская плаза").withPhone("999-99-98889"));
            app.goTo().updateData();
            app.goTo().pageHome();
            Set<ContactFio> after = app.contact().all();
            Assert.assertEquals(after.size(), before.size());

            before.remove(modifiedContact);

            before.add(contact);
            Assert.assertEquals(before, after);

        }

}
