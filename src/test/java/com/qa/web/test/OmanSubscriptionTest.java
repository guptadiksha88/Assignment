package com.qa.web.test;

import com.qa.web.base.TestBase;
import com.qa.web.pages.HomePage;
import com.qa.web.pages.PackageDetailsPage;
import com.qa.web.pages.PackageSelectionPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OmanSubscriptionTest extends TestBase {

    PackageSelectionPage packageSelection;
    PackageDetailsPage details;
    HomePage home;

    public OmanSubscriptionTest() {
        super();

    }

    @BeforeMethod
    public void setup() {
        Initialization();
        home = new HomePage();
        packageSelection = new PackageSelectionPage();
        details = new PackageDetailsPage();
        home.selectEnglishLanguage();
        home.clickCountry();
        home.clickOmanCountry();

    }


    @Test
    public void omanLitePackageValidation() {
        home.verifyCurrency("OMR");
        home.verifylitePrice("5 USD");
        packageSelection.selectLitePackage();
        details.verifyType("Lite");
        details.verifyPriceFromDetails("5.00 USD");
    }

    @Test
    public void omanClassicPackageValidation() {
        home.verifylitePrice("10 USD");
        packageSelection.selectClassicPackage();
        details.verifyType("Classic");
        details.verifyPriceFromDetails("10.00 USD");
    }

    @Test
    public void omanPremiumPackageValidation() {
        home.verifylitePrice("15 USD");
        packageSelection.selectPremiumPackage();
        details.verifyType("Premium");
        details.verifyPriceFromDetails("15.00 USD");
    }


    @AfterMethod
    public void teardown() {
        driver.close();
    }

}
