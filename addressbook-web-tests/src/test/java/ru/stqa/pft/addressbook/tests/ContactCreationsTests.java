package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.Comparator;
import java.util.List;

public class ContactCreationsTests extends TestBase{


    @Test
    public void testContactCreations() {


        List<ContactFio> before = app.contact().list();
        app.goTo().gotoPageContacts();

        ContactFio contact = new ContactFio().withName("fddgdfg").withMiddlename("dssdf").withLastname("sdfsdf");
        app.contact().createContactFio(contact);
        app.contact().createContactInformation(new ContactInformation().withNickname("serejka_sm").withTitle("Title").withCompany("equifax"));
        app.contact().createContactPhone(new ContactAddressPhone().withStreet("каланчевская плаза").withPhone("999-99-98889"));

        app.goTo().submitData();
        app.goTo().pageHome();
        List<ContactFio> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);


        Comparator<? super ContactFio> byId = Comparator.comparingInt(ContactFio::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
        app.goTo().logout();

    }


}
