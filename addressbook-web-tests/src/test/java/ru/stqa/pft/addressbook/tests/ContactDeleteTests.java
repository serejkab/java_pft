package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by SerejKa on 19.04.2017.
 */
public class ContactDeleteTests  extends TestBase{

    @Test
    public void testContactDeletion(){

        app.getNavigationHelper().gotoPageHome();
        app.getContactHelper().selectContact();
        app.getContactHelper().pushDeleteContact();
        app.getContactHelper().alertAccept();
        app.getNavigationHelper().gotoPageHome();

    }

}
