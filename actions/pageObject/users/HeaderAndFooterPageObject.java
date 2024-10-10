package pageObject.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUis.users.HeaderAndFooterPageUis;

public class HeaderAndFooterPageObject extends BasePage {
    WebDriver driver;

    public HeaderAndFooterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMyAccountHeaderLink() {
        waitForListElementClickAble(driver, HeaderAndFooterPageUis.MY_ACCOUNT_LINK);
        clickToElement(driver, HeaderAndFooterPageUis.MY_ACCOUNT_LINK);
    }
}
