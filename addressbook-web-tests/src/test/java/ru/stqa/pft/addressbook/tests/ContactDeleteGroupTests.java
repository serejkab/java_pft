package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

/**
 * Created by SerejKa on 31.05.2017.
 */
public class ContactDeleteGroupTests extends TestBase{

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
    public void testContactDeleteGroup() {

        Groups groups = app.db().groups();
        if(groups.size() == 0){
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("test1"));
        }
        app.goTo().pageHome();
        app.contact().selectGroupBeforeDelete(groups.iterator().next());
        Contacts before = app.contact().all();
        ContactFio modifiedContact = before.iterator().next();





    }

}
