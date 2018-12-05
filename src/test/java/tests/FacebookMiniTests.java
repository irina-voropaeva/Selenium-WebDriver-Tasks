package tests;

import Browser.BrowserController;
import Facebook.Pages.*;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class FacebookMiniTests {
    /*
    * @Author: Iryna Voropaieva
    * @Date: 04.12.2018
    * Additional info: Test should be run one by one for success. There is test Facebook account in comment line.
    * */
    private final String facebookMainPageUrl = "http://facebook.com";

    @Test
    public void loginTest() {

        String email = ""; //"test.for.dataart2018@gmail.com";
        String password = "";//"crazypasswordshouldbehere2018";

        BrowserController.openBrowserLink(facebookMainPageUrl);

        FacebookLogin.enterEmail(email);
        FacebookLogin.enterPassword(password);
        FacebookLogin.clickLogInButton();
            assertTrue(BrowserController.getBrowser()
                    .findElements(By.xpath("//span[@class='_2md']")).size() == 1); //if F logo is on the page

    }

    @Test
    public void searchGroup() {

        String searchText = "QA School 2018 – Kherson";

        FacebookMainPage.enterSearchValue(searchText);
        FacebookMainPage.clickSearchButton();
        BrowserController.getBrowser().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Actually, if test fails here, because Facebook search opens People search page, try again and again, and it will work
        //FacebookResultsPage.choosePagesTab();

        BrowserController.getBrowser().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        FacebookResultsPage.choosePageFromResults();
        BrowserController.getBrowser().manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        assertTrue(BrowserController.getBrowser()
                                    .getCurrentUrl()
                                    .contains("QA-School-2018-Kherson"));

    }

    @Test
    public void verifyPostAdding() {

        String valueToWrite = "Hello! All in all I passed Facebook reCaptcha! Ha-ha, Google, you are not as secure as you want to be!";

        BrowserController.getBrowser().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        FacebookGroupPage.addPost(valueToWrite);
        FacebookGroupPage.clickPostButton();

    }

   //@Test
    public void verifyLikePost() {

        searchGroup();
        FacebookGroupPage.likeLastPost();

    }

    @Test
    public void logOut() {

        FacebookLogOutMenu.clickSettingsMenu();
        FacebookLogOutMenu.clickLogOut();

    }
}
