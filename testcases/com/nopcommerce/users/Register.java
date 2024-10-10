package com.nopcommerce.users;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGenaratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.users.CustomerPageObject;
import pageObject.users.HomePageObject;
import pageObject.users.LoginPageObject;
import pageObject.users.RegisterPageObject;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Register extends BaseTest {
    private WebDriver driver;

    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private CustomerPageObject customerInfoPage;

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
    public void Register_01_Validate_Blank() {
        registerPage = homePage.clickRegisterLink();
        registerPage.clickRegisterButton();
        assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
        assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
        assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
        assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
    }

    @Test
    public void Register_02_Email_Invalid() {
        registerPage.sendKeyToFirstNameTextbox(firstName);
        registerPage.sendKeyToLastNameTextbox(lastName);
        registerPage.sendKeyToEmailTextbox(email + "@");
        registerPage.sendKeyToPasswordTextbox(password);
        registerPage.sendKeyToConfirmPasswordTextbox(password);
        assertEquals(registerPage.getEmailErrorMessage(), "Please enter a valid email address.");
    }

    @Test
    public void Register_03_Password_Mismatched_ConfirmPassword() {
        registerPage.clearFirstNameTextbox();
        registerPage.clearLastNameTextbox();
        registerPage.clearEmailTextbox();
        registerPage.clearPasswordTextbox();
        registerPage.clearConfirmPasswordTextbox();

        registerPage.sendKeyToFirstNameTextbox(firstName);
        registerPage.sendKeyToLastNameTextbox(lastName);
        registerPage.sendKeyToEmailTextbox(email);
        registerPage.sendKeyToPasswordTextbox(password);
        registerPage.sendKeyToConfirmPasswordTextbox(password + "@");
        assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
    }

    @Test
    public void Register_04_Register_Success_And_Verify_User_Info() {
        registerPage.clearFirstNameTextbox();
        registerPage.clearLastNameTextbox();
        registerPage.clearEmailTextbox();
        registerPage.clearPasswordTextbox();
        registerPage.clearConfirmPasswordTextbox();

        registerPage.sendKeyToFirstNameTextbox(firstName);
        registerPage.sendKeyToLastNameTextbox(lastName);
        registerPage.sendKeyToEmailTextbox(email);
        registerPage.sendKeyToPasswordTextbox(password);
        registerPage.sendKeyToConfirmPasswordTextbox(password);

        registerPage.clickRegisterButton();
        assertTrue(registerPage.isRegisterSuccessMessageDisplayed());
        assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

        homePage = registerPage.clickContinueButton();
        homePage.clickLogOutLink();
        loginPage = homePage.clickLoginLink();
        homePage = loginPage.loginWithUser(email, password);
        customerInfoPage = homePage.clickMyAccountLink();
        assertEquals(customerInfoPage.getFirstNameAttributeValue("value"), firstName);
        assertEquals(customerInfoPage.getLastNameAttributeValue("value"), lastName);
        assertEquals(customerInfoPage.getEmailAttributeValue("value"), email);
    }

    @AfterClass
    public void afterClass() {
        quitBrowserDriver();
    }
}
