package intro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileBrowser {

    @Test
    public void mobileBrowserTest() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"cigdem");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");

        URL url = new URL("http://localhost:4723/wd/hub");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://techtorialacademy.com");

        driver.get("https://facebook.com");
        driver.findElement(By.name("email")).sendKeys("techtorial");
        driver.findElement(By.name("pass")).sendKeys("techtorial");

        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("cigdem", Keys.RETURN);
    }
}
