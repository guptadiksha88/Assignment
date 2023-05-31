package com.qa.web.test;

import com.aventstack.extentreports.Status;
import com.qa.web.base.TestBase;
import com.qa.web.pages.HomePage;
import com.qa.web.pages.PackageDetailsPage;
import com.qa.web.pages.PackageSelectionPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class UAESubscriptionTest extends TestBase {

    PackageSelectionPage packageSelection;
    PackageDetailsPage details;
    HomePage home;

    public UAESubscriptionTest() {
        super();

    }

    @BeforeMethod
    public void setup() {
        Initialization();
        home= new HomePage();
        packageSelection = new PackageSelectionPage();
        details = new PackageDetailsPage();
        home.selectEnglishLanguage();

    }


    @Test
    public void uaeLitePackageValidation() {
        home.verifyCurrency("AED");
        home.verifylitePrice("5.4 USD");
        packageSelection.selectLitePackage();
        details.verifyType("Lite");
        details.verifyPriceFromDetails("5.40 USD");
    }

    @Test
    public void uaeClassicPackageValidation() {
        home.verifyClassicPrice("10.9 USD");
        packageSelection.selectClassicPackage();
        details.verifyType("Classic");
        details.verifyPriceFromDetails("10.90 USD");
    }

    @Test
    public void uaePremiumPackageValidation() {
        home.verifyPremiumPrice("16.3 USD");
        packageSelection.selectPremiumPackage();
        details.verifyType("Premium");
        details.verifyPriceFromDetails("16.30 USD");
    }


    @AfterMethod
    public void teardown() {
        driver.close();
    }

}
