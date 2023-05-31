package com.qa.web.pages;

import com.aventstack.extentreports.Status;
import com.qa.web.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.qa.web.utils.TestUtil.clickAt;


public class PackageSelectionPage extends TestBase {

    @FindBy(xpath = "//*[@id='lite-selection']")
    private WebElement litePackage;

    @FindBy(xpath = "//*[@id='classic-selection']")
    private WebElement classicPackage;

    @FindBy(xpath = "//*[@id='premium-selection']")
    private WebElement premiumPackage;


    public PackageSelectionPage() {
        PageFactory.initElements(driver, this);
    }


    public void selectLitePackage() {
        clickAt(driver, litePackage);
        extentLog.log(Status.INFO,customReport(" Lite Package is selected"));
    }

    public void selectClassicPackage() {
        clickAt(driver, classicPackage);
    }

    public void selectPremiumPackage() {
        clickAt(driver, premiumPackage);
    }

}
