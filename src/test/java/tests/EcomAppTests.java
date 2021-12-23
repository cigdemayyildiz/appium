package tests;

import common_utils.DriverUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import pages.EcomAppHomePage;

public class EcomAppTests {

    @Test
    public void loginTest(){
        AndroidDriver<AndroidElement> driver = DriverUtils.getAndroidDriver("ecommerce app");
        EcomAppHomePage ecomAppHomePage = new EcomAppHomePage(driver);
        ecomAppHomePage.login("cigdem");
    }
}
