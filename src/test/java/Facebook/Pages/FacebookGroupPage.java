package Facebook.Pages;

import Browser.BrowserController;
import org.openqa.selenium.By;

public class FacebookGroupPage {

    public static void addPost(String value) {

        BrowserController.getBrowser()
                .findElement(By.xpath("//div[@class='_3nd0']"))
                .click();
        BrowserController.getBrowser()
                .findElement(By.xpath("//div[@class='_3nd0']"))
                .sendKeys(value);

    }
    public static void clickPostButton() {

        BrowserController.getBrowser()
                .findElement(By.id("composerPostButton"))
                .click();

    }

    public static void likeLastPost() {
        //like post
    }

}
