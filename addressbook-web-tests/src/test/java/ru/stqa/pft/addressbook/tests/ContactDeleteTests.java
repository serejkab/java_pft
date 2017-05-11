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
    public void testContactDeletion(){

        List<ContactFio> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        app.goTo().pageHome();
        List<ContactFio> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before,after);

    }



}
