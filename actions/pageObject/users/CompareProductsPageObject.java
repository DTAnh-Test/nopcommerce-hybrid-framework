package pageObject.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUis.users.CompareProductsPageUis;

public class CompareProductsPageObject extends HeaderAndFooterPageObject{
    private WebDriver driver;

    public CompareProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyCompareProductsPageDisplayed() {
        Assert.assertTrue(isElementDisplayed(driver, CompareProductsPageUis.COMPARE_PRODUCTS_PAGE_TITLE));
    }

    public void verifyProductCompareDisplayed(String value) {
        Assert.assertTrue(isElementDisplayed(driver, CompareProductsPageUis.DYNAMIC_PRODUCTS_NAME,value));
    }

    public void clickToClearList() {
        waitForListElementClickAble(driver, CompareProductsPageUis.CLEAR_LIST_BUTTON);
        clickToElement(driver,CompareProductsPageUis.CLEAR_LIST_BUTTON);
    }

    public void verifyClearListSuccessNoti(String content) {
        waitForElementVisible(driver, CompareProductsPageUis.NOTI_NO_DATA);
        Assert.assertEquals(getElementText(driver, CompareProductsPageUis.NOTI_NO_DATA), content);
    }
}
