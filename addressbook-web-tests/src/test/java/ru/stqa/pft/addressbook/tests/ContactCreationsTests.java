package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationsTests extends TestBase{


    @Test
    public void testContactCreations() {


        Set<ContactFio> before = app.contact().all();
        app.goTo().gotoPageContacts();

        ContactFio contact = new ContactFio().withName("fddgdfg").withMiddlename("dssdf").withLastname("sdfsdf");
        app.contact().createContactFio(contact);
        app.contact().createContactInformation(new ContactInformation().withNickname("serejka_sm").withTitle("Title").withCompany("equifax"));
        app.contact().createContactPhone(new ContactAddressPhone().withStreet("каланчевская плаза").withPhone("999-99-98889"));

        app.goTo().submitData();
        app.goTo().pageHome();
        Set<ContactFio> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
        app.goTo().logout();

    }


}
