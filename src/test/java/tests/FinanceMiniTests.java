package tests;

import Browser.BrowserController;

import Finance.Pages.FinanceMainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class FinanceMiniTests {

    @Test
    public void verifySellUSDResult() {

        FinanceMainPage.openMainPage();
        String amount = "120";
        FinanceMainPage.enterMoneyToChange(amount);

        String actualResults = FinanceMainPage.getChangeResult();
        String expectedResults = FinanceMainPage.findExpectedResult(amount);

        assertTrue(actualResults == expectedResults);
    }
/*
*         float UAH = Float.valueOf(BrowserController.getBrowser().findElement(By.xpath("//p[@id='UAH']/input[@id='currency_rate']")).getText());
        float EUR = Float.valueOf(BrowserController.getBrowser().findElement(By.xpath("//p[@id='EUR']/input[@id='currency_rate']")).getText());
        float RUB = Float.valueOf(BrowserController.getBrowser().findElement(By.xpath("//p[@id='RUB']/input[@id='currency_rate']")).getText());

        float USD_to_UAH = Float.valueOf(BrowserController.getBrowser().findElement(By.xpath("//p[@id='UAH']/input[@id='currency_exchange']")).getText());
        float USD_to_EUR = Float.valueOf(BrowserController.getBrowser().findElement(By.xpath("//p[@id='EUR']/input[@id='currency_exchange']")).getText());
        float USD_to_RUB = Float.valueOf(BrowserController.getBrowser().findElement(By.xpath("//p[@id='RUB']/input[@id='currency_exchange']")).getText());

        float expected_USD_to_UAH = UAH * Float.valueOf(amount);
        float expected_USD_to_EUR = EUR * Float.valueOf(amount);
        float expected_USD_to_RUB = RUB * Float.valueOf(amount);
        System.out.println(expected_USD_to_UAH + "\n" + expected_USD_to_EUR + "\n" + expected_USD_to_RUB);*/


    @Test
    public void verifyAverageValues() {
        List<WebElement> USDcurrencyRates =
                BrowserController
                        .getBrowser()
                        .findElements(
                        By.xpath("//table[@id='latest_currency_container']/tbody[@class='bank_rates_usd']/tr[@role='row']/td[@class='sell_rate']"));

        float averageUSD = FinanceMainPage.findAverageCurrency(USDcurrencyRates);

        BrowserController.getBrowser()
                .findElement(By.xpath("//*[@id='latest_currency_selector']/li[2]"))
                .click();

        List<WebElement> EURcurrencyRates = BrowserController.getBrowser()
                                                                    .findElements(By.xpath("//table[@id='latest_currency_container']/tbody[@class='bank_rates_eur']/tr[@role='row']/td[@class='sell_rate']"));

        float averageEUR = FinanceMainPage.findAverageCurrency(EURcurrencyRates);

        BrowserController.getBrowser()
                .findElement(By.xpath("//*[@id='latest_currency_selector']/li[3]"))
                .click();

        List<WebElement> RUBcurrencyRates = BrowserController.getBrowser()
                                                                    .findElements(
                                                                     By.xpath("//table[@id='latest_currency_container']/tbody[@class='bank_rates_rub']/tr[@role='row']/td[@class='sell_rate']"));

        float averageRUB = FinanceMainPage.findAverageCurrency(RUBcurrencyRates);

        System.out.println("usd: " + averageUSD + "\n" + "eur: " + averageEUR + "\n" + "rub: " + averageRUB);

        float expectedUSD = (float) 0.0; //todo
        float expectedEUR = (float) 0.0; //todo
        float expectedRUB = (float) 0.0; //todo
        assertTrue(averageUSD == expectedUSD && averageEUR == expectedEUR && averageRUB == expectedRUB);
    }
}
