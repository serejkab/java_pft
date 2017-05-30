package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
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
        type(By.name("address"),contactFio.getAddress());
        type(By.name("home"),contactFio.getHomePhone());
        type(By.name("mobile"),contactFio.getMobilePhone());
        type(By.name("work"),contactFio.getWorkPhone());
        type(By.name("email"),contactFio.getEmail());
        type(By.name("email2"),contactFio.getEmail2());
        type(By.name("email3"),contactFio.getEmail3());

        attach(By.name("photo"), contactFio.getPhoto());

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

    public void contactAddToGroup(ContactFio contactFio){
        if (contactFio.getGroups().size() > 0){
            Assert.assertTrue(contactFio.getGroups().size() == 1);
            new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(contactFio.getGroups().iterator().next().getName());
        } else {
            Assert.assertFalse(isElementPresent(By.name("to_group")));
        }
        wd.findElement(By.name("add")).click();
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
            String address = cells.get(3).getText();
            String allMails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            contactCache.add(new ContactFio().withId(id).withName(name).withLastname(lastname).withAllMails(allMails)
                    .withAllPhones(allPhones).withAddress(address));
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
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        wd.navigate().back();
        return  new ContactFio().withId(contact.getId()).withName(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmail(email).withEmail2(email2).withEmail3(email3).withAddress(address);

    }

    private void initContactModificationById (int id) {

        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}
