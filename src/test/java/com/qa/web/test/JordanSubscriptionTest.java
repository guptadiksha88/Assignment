package com.qa.web.test;

import com.qa.web.base.TestBase;
import com.qa.web.pages.HomePage;
import com.qa.web.pages.PackageDetailsPage;
import com.qa.web.pages.PackageSelectionPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JordanSubscriptionTest extends TestBase {

    PackageSelectionPage packageSelection;
    PackageDetailsPage details;
    HomePage home;

    public JordanSubscriptionTest() {
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
        home.clickJordanCountry();

    }


    @Test
    public void jordanLitePackageValidation() {
        home.verifyCurrency("JOD");
        home.verifylitePrice("2.7 USD");
        packageSelection.selectLitePackage();
        details.verifyType("Lite");
        details.verifyPriceFromDetails("2.70 USD");
    }

    @Test
    public void jordanClassicPackageValidation() {
        home.verifylitePrice("5.2 USD");
        packageSelection.selectClassicPackage();
        details.verifyType("Classic");
        details.verifyPriceFromDetails("5.20 USD");
    }

    @Test
    public void jordanPremiumPackageValidation() {
        home.verifylitePrice("8 USD");
        packageSelection.selectPremiumPackage();
        details.verifyType("Premium");
        details.verifyPriceFromDetails("8.00 USD");
    }


    @AfterMethod
    public void teardown() {
        driver.close();
    }

}
