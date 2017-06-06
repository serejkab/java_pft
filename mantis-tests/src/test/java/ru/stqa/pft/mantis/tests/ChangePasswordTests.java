package ru.stqa.pft.mantis.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.mantis.Model.User;
import ru.stqa.pft.mantis.Model.Users;
import ru.stqa.pft.mantis.appmanager.HttpSession;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;

/**
 * Created by SerejKa on 05.06.2017.
 */
public class ChangePasswordTests extends TestBase {

     @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testChangePassword() throws IOException {

        String user = "administrator";
        String password = "root";
       app.registration().login(user, password);



       HttpSession session = app.newSession();
        session.login("administrator", "root");


    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer(){
        app.mail().stop();
    }

}
