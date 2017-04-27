package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

/**
 * Created by SerejKa on 18.04.2017.
 */
public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactAddressPhone(ContactAddressPhone contactAddressPhone) {

       type(By.name("address"),contactAddressPhone.getStreet());
       type(By.name("home"),contactAddressPhone.getPhone());

    }

    public void fillContactInformation(ContactInformation contactInformation) {

        type(By.name("nickname"),contactInformation.getNickname());
        type(By.name("title"),contactInformation.getTitle());
        type(By.name("company"),contactInformation.getCompany());

    }

    public void fillContactFio(ContactFio contactFio) {

        type(By.name("firstname"),contactFio.getName());
        type(By.name("middlename"),contactFio.getMiddlename());
        type(By.name("lastname"),contactFio.getLastname());

    }


    public void selectContact(){

        click(By.name("selected[]"));
    }

    public void pushEdit(){

       click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void pushDeleteContact(){

       click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void alertAccept(){

        wd.switchTo().alert().accept();
    }
}
