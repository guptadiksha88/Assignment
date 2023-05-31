package com.qa.web.pages;

import com.aventstack.extentreports.Status;
import com.qa.web.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static com.qa.web.utils.TestUtil.*;


public class HomePage extends TestBase {

    @FindBy(linkText = "English")
    private WebElement languageEng;

    @FindBy(xpath = "//*[@class='trial-cost']")
    private WebElement countryCurrency;
    @FindBy(xpath = "//*[@id='country-btn']")
    private WebElement countryButton;
    @FindBy(xpath = "//*[@id='om-contry-flag']")
    private WebElement oman;
    @FindBy(xpath = "//*[@id='jo-contry-lable']")
    private WebElement jordan;

    @FindBy(xpath = "//*[@id='currency-lite']")
    private WebElement litePrice;

    @FindBy(xpath = "//*[@id='currency-classic']")
    private WebElement classicPrice;

    @FindBy(xpath = "//*[@id='currency-premium']")
    private WebElement premiumPrice;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void selectEnglishLanguage() {
        clickAt(driver, languageEng);
        extentLog.log(Status.INFO, customReport("English Language is Selected"));
    }

    public void clickCountry() {
        clickAt(driver, countryButton);
    }

    public void clickOmanCountry() {
        clickAt(driver, oman);
        extentLog.log(Status.INFO, customReport("Country Oman is Selected"));
    }

    public void clickJordanCountry() {
        clickAt(driver, jordan);
        extentLog.log(Status.INFO, customReport("Country Jordan is Selected"));
    }


    public void verifyCurrency(String currency) {

        Assert.assertTrue(countryCurrency.getText().contains(currency));
        extentLog.log(Status.INFO, customReport(" Currency is correct"));
    }

    public void verifylitePrice(String price) {

        Assert.assertTrue(litePrice.getText().contains(price));
        extentLog.log(Status.INFO, customReport("Lite Package Price is correct"));
    }

    public void verifyClassicPrice(String price) {

        Assert.assertTrue(classicPrice.getText().contains(price));
        extentLog.log(Status.INFO, customReport("Classic Package Price is correct"));
    }

    public void verifyPremiumPrice(String price) {

        Assert.assertTrue(premiumPrice.getText().contains(price));
        extentLog.log(Status.INFO, customReport("Premium Package Price is correct"));
    }

}
