package intro;

import common_utils.DriverUtils;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class ErrorMessage {

    @Test
    public void toastMessageTest(){
        AndroidDriver<AndroidElement> driver = DriverUtils.getAndroidDriver("ecommerce app");
        AndroidElement letsShop = driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(letsShop))).perform();
        AndroidElement toastMessage = driver.findElement(By.xpath("//android.widget.Toast"));
        String errorMsgText = toastMessage.getAttribute("name");
        System.out.println("Error msg is:" + errorMsgText);

        Assert.assertEquals("Please enter your name", errorMsgText);

        DriverUtils.tap(driver, letsShop);
        toastMessage = driver.findElement(By.xpath("//android.widget.Toast[text()='Please enter your name']"));

        Assert.assertEquals("Please enter your name", toastMessage.getAttribute("name"));


    }
}
