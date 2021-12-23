package intro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static common_utils.DriverUtils.getAndroidDriver;

public class Locators {

    @Test
    public void accessibilityIdTest(){

        File apkFile = new File("src/test/resources/apks/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("deviceName", "cigdem");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("app",apkFile.getAbsolutePath());

        URL serverUrl;

        try {
            serverUrl = new URL("http://localHost:4723/wd/hub");
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        }

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(serverUrl,desiredCapabilities);

        AndroidElement appButton = driver.findElementByAccessibilityId("App");
        appButton.click();

        AndroidElement alarmButton = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Alarm\"]"));
        alarmButton.click();

        AndroidElement alarmControllerButton = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Alarm Controller\"]"));
        alarmControllerButton.click();

        AndroidElement oneShotAlarmButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"One Shot Alarm\"]"));
        oneShotAlarmButton.click();
        String oneShotAlarmButtonText = oneShotAlarmButton.getText();
        Assert.assertEquals("ONE SHOT ALARM", oneShotAlarmButtonText);
    }


    @Test
    public void multipleElementsTest(){
        AndroidDriver<AndroidElement> driver = getAndroidDriver();

        List<AndroidElement> appElements = driver.findElements(By.className("android.widget.TextView"));
        for (AndroidElement element: appElements){
            System.out.println(element.getText());
        }
    }

    @Test
    public void uiautomatorTest(){
        AndroidDriver<AndroidElement> driver = getAndroidDriver();
        AndroidElement accessibility = driver.findElementByAndroidUIAutomator("text(\"Access'ibility\")");
        accessibility.click();
    }
}
