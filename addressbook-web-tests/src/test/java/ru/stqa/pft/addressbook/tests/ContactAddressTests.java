package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactFio;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by SerejKa on 18.05.2017.
 */
public class ContactAddressTests extends TestBase{

    @Test
    public void testContactAddresses() {
        app.goTo().pageHome();
        ContactFio contact = app.contact().all().iterator().next();
        ContactFio contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        MatcherAssert.assertThat(contact.getAddress(), CoreMatchers.equalTo(mergeAddresses(contactInfoFromEditForm)));


}

    private String mergeAddresses(ContactFio contact) {
        return Arrays.asList(contact.getAddress()).stream()
                .filter((s) -> !s.equals(""))
                .map(ContactAddressTests::cleaned)
                .collect(Collectors.joining("\n"));

    }

    public static String cleaned(String mail) {

        return mail.replaceAll("\\s", "");

    }
}