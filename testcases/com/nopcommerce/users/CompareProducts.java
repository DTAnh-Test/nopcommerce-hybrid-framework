package com.nopcommerce.users;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGenaratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.users.*;

public class CompareProducts extends BaseTest {
    private WebDriver driver;

    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private CompareProductsPageObject compareProductsPage;

    private String userUrl = GlobalConstants.USER_URL;
    private String email = getEmailAddress();
    private String firstName = getFirstName();
    private String lastName = getLastName();
    private String password = getPassword();
    private String productNameFirst = "Apple MacBook Pro";
    private String productNameSecond = "HTC smartphone";

    @Parameters({"browser"})
    @BeforeClass
    public void beforeClass(String browserName) {
        driver = getBrowserDriver(browserName, userUrl);
        homePage = PageGenaratorManager.getHonePage(driver);
    }

    @Test
    public void MyAccount_01_SideBar_Navigation() {
        registerPage = homePage.clickRegisterLink();
        registerPage.registerSuccess(firstName, lastName, email, password);

        homePage = registerPage.clickContinueButton();
        homePage.addProductToCompareList("Featured products",productNameFirst,"Add to compare list");
        homePage.addProductToCompareList("Featured products",productNameSecond,"Add to compare list");
        compareProductsPage = homePage.clickToViewCompareResult();
        compareProductsPage.verifyCompareProductsPageDisplayed();
        compareProductsPage.verifyProductCompareDisplayed(productNameFirst);
        compareProductsPage.verifyProductCompareDisplayed(productNameSecond);

        compareProductsPage.clickToClearList();
        compareProductsPage.verifyClearListSuccessNoti("You have no items to compare.");

    }

    @AfterClass
    public void afterClass() {
        quitBrowserDriver();
    }
}
