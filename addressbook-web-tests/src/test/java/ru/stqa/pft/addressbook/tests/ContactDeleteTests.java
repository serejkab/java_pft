package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by SerejKa on 19.04.2017.
 */
public class ContactDeleteTests  extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().pageHome();
        if(app.contact().all().size() == 0)
        {
            app.goTo().gotoPageContacts();
            app.contact().createContactFio(new ContactFio().withName("fddgdfg").withMiddlename("dssdf").withLastname("sdfsdf"));
            app.goTo().submitData();
            app.goTo().pageHome();
        }

    }

    @Test
    public void testContactDeletion(){

       Contacts before = app.contact().all();
        ContactFio deleteContact = before.iterator().next();
        app.contact().delete(deleteContact);
        app.goTo().pageHome();
        assertEquals(app.contact().count(), before.size() - 1);
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deleteContact)));


    }



}
