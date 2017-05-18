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
public class ContactMailTests extends TestBase {

    @Test
    public void testContactMails() {
        app.goTo().pageHome();
        ContactFio contact = app.contact().all().iterator().next();
        ContactFio contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        MatcherAssert.assertThat(contact.getAllMails(), CoreMatchers.equalTo(mergeMails(contactInfoFromEditForm)));

    }

    private String mergeMails(ContactFio contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3()).stream()
                .filter((s) -> !s.equals(""))
                .map(ContactMailTests::cleaned)
                .collect(Collectors.joining("\n"));

    }

    public static String cleaned(String mail) {

        return mail.replaceAll("\\s", "");

    }
}