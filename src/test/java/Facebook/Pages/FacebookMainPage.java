package Facebook.Pages;

import Browser.BrowserController;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import java.util.concurrent.TimeUnit;

public class FacebookMainPage {

    public static void enterSearchValue(String value) {

        //Sometimes my connection is too slow, so I need the implicitlyWait(). You can safely delete this, if your Internet connection is fast
        BrowserController.getBrowser()
                .manage()
                .timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);

        BrowserController.getBrowser()
                .findElement(By.xpath("//input[@aria-label='Search']"))
                .sendKeys(value);

    }

    public static void clickSearchButton() {

        BrowserController.getBrowser()
                .findElement(By.xpath("//input[@aria-label='Search']"))
                .sendKeys(Keys.ENTER);

    }
}
