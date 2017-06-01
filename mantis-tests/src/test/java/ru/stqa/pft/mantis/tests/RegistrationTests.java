package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

/**
 * Created by SerejKa on 01.06.2017.
 */
public class RegistrationTests extends TestBase{

@Test
    public void testRegistration() {

    app.registration().start("user1", "user@localhost.ru");

}

}
