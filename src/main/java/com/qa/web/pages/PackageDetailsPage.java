package com.qa.web.pages;

import com.aventstack.extentreports.Status;
import com.qa.web.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class PackageDetailsPage extends TestBase {

    @FindBy(xpath = "//*[@id='order-tier-name']")
    private WebElement planType;

    @FindBy(xpath = "//*[@id='order-tier-price']")
    private WebElement planPrice;



    public PackageDetailsPage() {
        PageFactory.initElements(driver, this);
    }


    public void verifyType(String type) {
        Assert.assertTrue(planType.getText().contains(type));
        extentLog.log(Status.INFO,customReport(" Package Type is correct"));
    }

    public void verifyPriceFromDetails(String price) {

        Assert.assertTrue(planPrice.getText().contains(price));
        extentLog.log(Status.INFO,customReport("Price from details is correct"));
    }


}
