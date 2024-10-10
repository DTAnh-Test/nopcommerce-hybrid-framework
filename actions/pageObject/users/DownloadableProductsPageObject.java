package pageObject.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUis.users.CustomerPageUi;
import pageUis.users.DownloadableProductsPageUi;

public class DownloadableProductsPageObject extends SideBarMyAccountPageObject {
    WebDriver driver;

    public DownloadableProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyDownloadablePageDisplayed() {
        Assert.assertTrue(isElementDisplayed(driver, DownloadableProductsPageUi.DOWNLOADABLE_PAGE_TITLE));
    }
}
