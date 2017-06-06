package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.mantis.Model.User;

import java.util.List;

/**
 * Created by SerejKa on 06.06.2017.
 */
public class UserHelper extends HelperBase {


    public UserHelper(ApplicationManager app) {
        super(app);
    }


    public User all() {
        User users = new User();
        List<WebElement> elements = wd.findElements(By.cssSelector("tr[class=row-1]"));
        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));


        }
        return null;

    }
}