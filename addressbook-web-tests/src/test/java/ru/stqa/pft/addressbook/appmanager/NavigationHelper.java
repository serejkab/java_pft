package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by SerejKa on 18.04.2017.
 */
public class NavigationHelper extends HelperBase {




    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void gotoPageContacts() {
        click(By.linkText("add new"));
    }

    public void gotoPageHome(){
        click(By.linkText("home"));

    }

    public void submitData() {
        click(By.name("submit"));
    }

    public void updateData() {

        click(By.xpath("//div[@id='content']/form[1]/input[22]"));
    }

    public void logout() {
        click(By.linkText("Logout"));
    }
}
