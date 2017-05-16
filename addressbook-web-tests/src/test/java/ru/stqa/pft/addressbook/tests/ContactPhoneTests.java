package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactFio;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by SerejKa on 15.05.2017.
 */
public class ContactPhoneTests extends TestBase {

    @Test
    public void testContactPhones(){
        app.goTo().pageHome();
        ContactFio contact = app.contact().all().iterator().next();
        ContactFio contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));


    }

    private String mergePhones(ContactFio contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone()).stream()
                .filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));

    }

    public static String cleaned(String phone){

        return phone.replaceAll("\\s", "").replaceAll("[-()]","");
    }

}
