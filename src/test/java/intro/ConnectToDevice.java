package intro;

import io.appium.java_client.android.AndroidBatteryInfo;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class ConnectToDevice {

    @Test
    public void test1() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","android");
        desiredCapabilities.setCapability("deviceName","cigdem");
        desiredCapabilities.setCapability("automationName","uiautomator2");

        URL serverUrl = new URL("http://localHost:4723/wd/hub");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(serverUrl, desiredCapabilities);

        AndroidBatteryInfo batteryInfo = driver.getBatteryInfo();
        System.out.println(batteryInfo.getState().name());
        System.out.println(driver.getDeviceTime());
        System.out.println(driver.getStatus());
    }
}
