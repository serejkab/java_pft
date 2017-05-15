package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

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

            Contacts before = app.contact().all();
            ContactFio modifiedContact = before.iterator().next();
            app.contact().selectContactById(modifiedContact.getId());
            app.contact().pushEdit(modifiedContact.getId());
            ContactFio contact = new ContactFio().withId(modifiedContact.getId()).withName("fddgdfg").withMiddlename("dssdf").withLastname("sdfsdf");
            app.contact().fillContactFio(contact);
            app.contact().fillContactInformation(new ContactInformation().withNickname("serejka_sm").withTitle("Title").withCompany("equifax"));
            app.contact().fillContactAddressPhone(new ContactAddressPhone().withStreet("каланчевская плаза").withPhone("999-99-98889"));
            app.goTo().updateData();
            app.goTo().pageHome();
            Contacts  after = app.contact().all();
            assertEquals(after.size(), before.size());

            assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

        }

}
