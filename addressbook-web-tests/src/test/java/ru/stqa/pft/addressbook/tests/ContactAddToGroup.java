package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by SerejKa on 30.05.2017.
 */
public class ContactAddToGroup extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){

        app.goTo().pageHome();
        if(app.db().contacts().size() == 0)
        {
            app.goTo().gotoPageContacts();
            app.contact().createContactFio(new ContactFio().withName("fddgdfg").withMiddlename("dssdf").withLastname("sdfsdf").withAddress("dfsdfsdf").withEmail("asdasd")
                    .withEmail2("sadsafaf").withEmail3("dsfsdff").withHomePhone("34324234").withMobilePhone("34234234").withWorkPhone("32423423423"));
            app.goTo().submitData();
            app.goTo().pageHome();
        }
    }


@Test
  public void testContactAddToGroup(){

    Groups groups = app.db().groups();
    if(groups.size() == 0){
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("test1"));
    }
    app.goTo().pageHome();
    Contacts before = app.db().contacts();
    ContactFio modifiedContact = before.iterator().next();
    app.contact().selectContactById(modifiedContact.getId());
    ContactFio contact = new ContactFio().withId(modifiedContact.getId()).withLastname(modifiedContact.getLastname()).withName(modifiedContact.getName())
            .withMiddlename(modifiedContact.getMiddlename()).withAddress(modifiedContact.getAddress()).withMobilePhone(modifiedContact.getMobilePhone())
            .withHomePhone(modifiedContact.getHomePhone()).withWorkPhone(modifiedContact.getWorkPhone()).withEmail(modifiedContact.getEmail()).
                    withEmail2(modifiedContact.getEmail2()).withEmail3(modifiedContact.getEmail3())
            .inGroup(groups.iterator().next());
    app.contact().contactAddToGroup(contact);
    app.goTo().pageHome();
    app.contact().contactCache = null;
    assertEquals(app.contact().count(), before.size());
    Contacts  after = app.db().contacts();

    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    verifyContactListInIU();
  }


}
