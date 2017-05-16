package ru.stqa.pft.addressbook.tests;



import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationsTests extends TestBase{


    @Test
    public void testContactCreations() {


        Contacts before = app.contact().all();
        app.goTo().gotoPageContacts();

        ContactFio contact = new ContactFio().withName("fddgdsdfsdffg").withMiddlename("dssdf").withLastname("sdfsdf");
        app.contact().createContactFio(contact);
        app.goTo().submitData();
        app.goTo().pageHome();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
        app.goTo().logout();

    }

    @Test
    public void testBadContactCreations() {


        Contacts before = app.contact().all();
        app.goTo().gotoPageContacts();

        ContactFio contact = new ContactFio().withName("fd'").withMiddlename("dssdf").withLastname("sdfsdf");
        app.contact().createContactFio(contact);
        app.goTo().submitData();
        app.goTo().pageHome();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
        app.goTo().logout();

    }

}
