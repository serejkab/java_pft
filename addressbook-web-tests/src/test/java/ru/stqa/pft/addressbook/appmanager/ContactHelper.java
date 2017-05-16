package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactFio;
import ru.stqa.pft.addressbook.model.Contacts;


import java.util.List;

/**
 * Created by SerejKa on 18.04.2017.
 */
public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
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



    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {

        return wd.findElements(By.name("selected[]")).size();
    }

    public Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null){
            return new Contacts(contactCache);
        }

        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=entry]"));

        for (WebElement element : elements){
            List<WebElement> cells = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastname = cells.get(1).getText();
            String name = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            contactCache.add(new ContactFio().withId(id).withName(name).withLastname(lastname)
                    .withAllPhones(allPhones));
        }
        return new Contacts(contactCache);
    }



    public void delete(ContactFio contact) {
        selectContactById(contact.getId());
        pushDeleteContact();
        alertAccept();
        contactCache = null;
    }

    public ContactFio infoFromEditForm(ContactFio contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return  new ContactFio().withId(contact.getId()).withName(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);

    }

    private void initContactModificationById (int id) {

        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}
