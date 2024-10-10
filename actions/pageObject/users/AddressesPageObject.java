package pageObject.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUis.users.AddressesPageUi;
import pageUis.users.DownloadableProductsPageUi;

public class AddressesPageObject extends SideBarMyAccountPageObject {
    WebDriver driver;

    public AddressesPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyAddressPageDisplayed() {
        Assert.assertTrue(isElementDisplayed(driver, AddressesPageUi.ADDRESS_PAGE_TITLE));
    }
}
