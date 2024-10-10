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

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyAccount extends BaseTest {
    private WebDriver driver;

    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerPageObject customerPage;
    private AddressesPageObject addressesPage;
    private DownloadableProductsPageObject downloadablePage;
    private RewardPointsPageObject rewardPointsPage;

    private String userUrl = GlobalConstants.USER_URL;
    private String email = getEmailAddress();
    private String firstName = getFirstName();
    private String lastName = getLastName();
    private String password = getPassword();

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

        registerPage.clickMyAccountHeaderLink();
        customerPage = PageGenaratorManager.getCustomerPage(driver);

        customerPage.openDynamicSideBarPage("Downloadable products");
        downloadablePage = PageGenaratorManager.getDownloadablePage(driver);

        // Downloadable products -> Addresses
        downloadablePage.openDynamicSideBarPage("Addresses");
        addressesPage =  PageGenaratorManager.getAddressesPage(driver);

        // Addresses -> Reward points
        addressesPage.openDynamicSideBarPage("Reward points");
        rewardPointsPage = PageGenaratorManager.getRewardPointPage(driver);

        // Reward points -> Customer info
        rewardPointsPage.openDynamicSideBarPage("Customer info");
        customerPage = PageGenaratorManager.getCustomerPage(driver);

        // Customer info -> Addresses
        customerPage.openDynamicSideBarPage("Addresses");
        addressesPage =  PageGenaratorManager.getAddressesPage(driver);

        // Addresses -> Downloadable products
        addressesPage.openDynamicSideBarPage("Downloadable products");
        downloadablePage = PageGenaratorManager.getDownloadablePage(driver);
    }

    @AfterClass
    public void afterClass() {
        quitBrowserDriver();
    }
}
