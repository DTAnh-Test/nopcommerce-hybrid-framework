package pageObject.users;

import commons.BasePage;
import commons.PageGenaratorManager;
import org.openqa.selenium.WebDriver;
import pageUis.users.HomePageUi;

public class HomePageObject extends HeaderAndFooterPageObject {
    // Chứa những action của page: click/ select/getText/...
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public RegisterPageObject clickRegisterLink() {
        waitForListElementClickAble(driver, HomePageUi.REGISTER_LINK);
        clickToElement(driver, HomePageUi.REGISTER_LINK);
        return PageGenaratorManager.getRegisterPage(driver);
    }

    public CustomerPageObject clickMyAccountLink() {
        waitForListElementClickAble(driver, HomePageUi.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUi.MY_ACCOUNT_LINK);
        return PageGenaratorManager.getCustomerPage(driver);
    }

    public LoginPageObject clickLoginLink() {
        waitForListElementClickAble(driver, HomePageUi.LOGIN_LINK);
        clickToElement(driver, HomePageUi.LOGIN_LINK);
        return PageGenaratorManager.getLoginPage(driver);
    }

    public void clickLogOutLink() {
        waitForListElementClickAble(driver, HomePageUi.LOG_OUT_LINK);
        clickToElement(driver, HomePageUi.LOG_OUT_LINK);
    }

    public void addProductToCompareList(String... value) {
        waitForListElementClickAble(driver, HomePageUi.DYNAMIC_FEATURED_PRODUCTS_BUTTON, value);
        clickToElement(driver, HomePageUi.DYNAMIC_FEATURED_PRODUCTS_BUTTON, value);
    }

    public CompareProductsPageObject clickToViewCompareResult() {
        waitForElementVisible(driver, HomePageUi.COMPARE_PRODUCTS_LINK);
        waitForListElementClickAble(driver, HomePageUi.COMPARE_PRODUCTS_LINK);
        clickToElement(driver, HomePageUi.COMPARE_PRODUCTS_LINK);
        return PageGenaratorManager.getCompareProductsPage(driver);
    }
}
