package Finance.Pages;

import Browser.BrowserController;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FinanceMainPage {

    public static void openMainPage() {

        String financeWebPage = "https://finance.i.ua/";

        BrowserController.openBrowserLink(financeWebPage);
    }

    public static void enterMoneyToChange(String money) {
        BrowserController.getBrowser().findElement(By.id("currency_amount"))
                .sendKeys(money);
    }

    public static String findExpectedResult(String money) {
        return new String();
    }

    public static String getChangeResult() {
        return new String();
    }

    public static float findAverageCurrency(List<WebElement> currencyRatesSource) {
        System.out.println("currency rate: " + BrowserController.getBrowser().findElement(By.xpath("//*[@id=\"currency_rate\"]")).getText());

        ArrayList<Float> currencyRates = new ArrayList<Float>();
        for (int i = 0; i < currencyRatesSource.size(); i++) {
            currencyRates.add(Float.valueOf(currencyRatesSource.get(i).getText()));
        }

        float tempRes = 0;
        for (int i = 0; i < currencyRates.size(); i++) {
            tempRes += currencyRates.get(i);
        }
        return tempRes/currencyRates.size();
    }

}
