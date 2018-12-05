package Facebook.Pages;

import Browser.BrowserController;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class FacebookResultsPage {

    public static void choosePagesTab() {

        BrowserController.getBrowser()
                .manage()
                .timeouts()
                .implicitlyWait(25, TimeUnit.SECONDS);

        if (BrowserController.getBrowser().findElements(By.xpath("//*[@id='u_fetchstream_2_1']/div/div/div/ul/li[1]/a/div/div[1][@aria-selected='false']")).size() > 0) {
            BrowserController.getBrowser()
                    .findElement(By.xpath("//a[@class='_3m1v _468f']/div[@class='_4jq5']/div[@class='_4xjz']"))
                    .click();
        }
        BrowserController.getBrowser().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    public static void choosePageFromResults() {

        BrowserController.getBrowser()
                .findElement(By.xpath("//div[text() = 'QA School 2018 - Kherson']"))
                .click();

    }
}
