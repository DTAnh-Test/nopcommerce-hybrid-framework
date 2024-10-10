package pageObject.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUis.users.AddressesPageUi;
import pageUis.users.RewardPointsPageUi;

public class RewardPointsPageObject extends SideBarMyAccountPageObject {
    WebDriver driver;

    public RewardPointsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void verifyRewardPageDisplayed() {
        Assert.assertTrue(isElementDisplayed(driver, RewardPointsPageUi.REWARD_PAGE_TITLE));
    }
}
