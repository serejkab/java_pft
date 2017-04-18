package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

/**
 * Created by SerejKa on 18.04.2017.
 */
public class ContactHelper extends HelperBase {


    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void fillContactAddressPhone(ContactAddressPhone contactAddressPhone) {

       type(By.name("address"),contactAddressPhone.getStreet());
       click(By.name("theform"));
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

}
