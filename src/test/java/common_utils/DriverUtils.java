package common_utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverUtils {

    public static AndroidDriver<AndroidElement> getAndroidDriver(String apkName){
        File apkFile = new File("src/test/resources/apks/"+apkName+".apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"cigdem");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());
        URL serverUrl;
        try {
            serverUrl = new URL("http://localHost:4723/wd/hub");
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(serverUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        return driver;
    }

    public static AndroidDriver<AndroidElement> getAndroidDriver(){

        File apkFile = new File("src/test/resources/apks/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"cigdem");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP,apkFile.getAbsolutePath());

        URL serverUrl;
        try {
            serverUrl = new URL("http://localHost:4723/wd/hub");
        }catch (MalformedURLException e){
            throw new RuntimeException(e);
        }
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(serverUrl,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static void tap(AndroidDriver<AndroidElement> driver, AndroidElement targetElement){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(targetElement))).perform();
    }

    public static void longPress(AndroidDriver<AndroidElement> driver, AndroidElement targetElement){
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(targetElement))
                .withDuration(Duration.ofSeconds(2))).perform();
    }
}
