package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by SerejKa on 18.04.2017.
 */
public class ApplicationManager {

    FirefoxDriver wd;

    private SessionHelper sessionHelper;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;



    public void init() {
       wd = new FirefoxDriver();
       wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
       wd.get("http://localhost/addressbook/group.php");
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);

        sessionHelper.login("admin", "secret");
    }



    public void stop() {
        wd.quit();
    }



    public void logout() {
        wd.findElement(By.linkText("Logout")).click();
    }

    public void gotoPageHome() {
        wd.findElement(By.linkText("home")).click();
    }

    public void submitData() {
        wd.findElement(By.name("submit")).click();
    }

    public void gotoPageContacts() {
        wd.findElement(By.linkText("add new")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }
}
