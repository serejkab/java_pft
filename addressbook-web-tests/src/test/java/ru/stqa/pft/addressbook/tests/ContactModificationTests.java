package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

/**
 * Created by SerejKa on 19.04.2017.
 */
public class ContactModificationTests extends TestBase{

        @Test
        public void testContactModification(){


            app.getNavigationHelper().gotoPageHome();
            app.getContactHelper().selectContact();
            app.getContactHelper().pushEdit();
            app.getContactHelper().fillContactFio(new ContactFio("Тестиру44444и", "44444", "444444444"));
            app.getContactHelper().fillContactInformation(new ContactInformation("serejka_sm", "Title", "equifax"));
            app.getContactHelper().fillContactAddressPhone(new ContactAddressPhone("800000 kkkkkkkkk", "999-9999777-99"));
            app.getNavigationHelper().updateData();

        }

}
