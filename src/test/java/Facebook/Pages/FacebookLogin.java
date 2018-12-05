package Facebook.Pages;

import Browser.BrowserController;
import org.openqa.selenium.By;

public class FacebookLogin {

    public static void enterEmail(String email) {

        BrowserController.getBrowser()
                .findElement(By.id("email"))
                .sendKeys(email);

    }

    public static void enterPassword(String password) {

        BrowserController.getBrowser()
                .findElement(By.id("pass"))
                .sendKeys(password);

    }

    public static void clickLogInButton() {

        BrowserController.getBrowser()
                .findElement(By.xpath("//input[@data-testid='royal_login_button']"))
                .click();

    }
}
