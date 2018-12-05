package Browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserController {

    private static WebDriver browser;

    public static void setBrowser() {

        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        browser = new ChromeDriver();

    }

    public static void openBrowserLink(String url) {

        if (browser == null) {
            setBrowser();
        }

        browser.get(url);
    }

    public static WebDriver getBrowser() {

        if (browser == null) {
            setBrowser();
        }
        return browser;
    }
}
