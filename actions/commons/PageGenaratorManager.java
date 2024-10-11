package commons;

import org.openqa.selenium.WebDriver;
import pageObject.users.*;

public class PageGenaratorManager {
    
    public static HomePageObject getHonePage(WebDriver driver){
        return new HomePageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver){
        return new LoginPageObject(driver);
    }

    public static RegisterPageObject getRegisterPage(WebDriver driver){
        return new RegisterPageObject(driver);
    }

    public static CustomerPageObject getCustomerPage(WebDriver driver){
        return new CustomerPageObject(driver);
    }

    public static AddressesPageObject getAddressesPage(WebDriver driver){
        return new AddressesPageObject(driver);
    }

    public static DownloadableProductsPageObject getDownloadablePage(WebDriver driver){
        return new DownloadableProductsPageObject(driver);
    }

    public static RewardPointsPageObject getRewardPointPage(WebDriver driver){
        return new RewardPointsPageObject(driver);
    }

    public static CompareProductsPageObject getCompareProductsPage(WebDriver driver){
        return new CompareProductsPageObject(driver);
    }
}
