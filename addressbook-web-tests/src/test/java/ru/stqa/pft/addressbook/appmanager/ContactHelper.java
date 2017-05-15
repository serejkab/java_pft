package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactAddressPhone;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.ContactInformation;
import ru.stqa.pft.addressbook.model.Contacts;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

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




    public void selectContactById(int id){

        wd.findElement(By.cssSelector("input[value='"+ id +"']")).click();

    }

    public void pushEdit(int id){

     wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

    }

    public void pushDeleteContact(){

       click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void alertAccept(){

        wd.switchTo().alert().accept();
    }


    public void createContactFio(ContactFio contactFio) {

        fillContactFio(contactFio);
        contactCache = null;

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

    public int count() {

        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null){
            return new Contacts(contactCache);
        }

        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));

        for (WebElement element : elements){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String lastname = cells.get(1).getText();
            String name = cells.get(2).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            contactCache.add(new ContactFio().withId(id).withName(name).withLastname(lastname));
        }
        return new Contacts(contactCache);
    }



    public void delete(ContactFio contact) {
        selectContactById(contact.getId());
        pushDeleteContact();
        alertAccept();
        contactCache = null;
    }

}
