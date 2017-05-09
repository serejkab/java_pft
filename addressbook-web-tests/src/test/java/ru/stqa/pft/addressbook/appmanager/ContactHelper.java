package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;

import java.util.ArrayList;
import java.util.List;

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


    public void selectContact(int index){

        wd.findElements(By.name("selected[]")).get(index).click();


    }

    public void pushEdit(int id){

        WebElement checkbox = wd.findElement(By.id(Integer.toString(id)));

        checkbox.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).click();




    }

    public void pushDeleteContact(){

       click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void alertAccept(){

        wd.switchTo().alert().accept();
    }


    public void createContactFio(ContactFio contactFio) {

        fillContactFio(contactFio);

    }


    public void createContactInformation(ContactInformation contactInformation) {

        fillContactInformation(contactInformation);
    }


    public void createContactPhone(ContactAddressPhone contactAddressPhone) {

        fillContactAddressPhone(contactAddressPhone);
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {

        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactFio> getContactList() {

        List<ContactFio> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));
        for (WebElement element : elements){
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactFio contact = new ContactFio(id, name, null,null);
            contacts.add(contact);
    }
    return contacts;
    }
}
