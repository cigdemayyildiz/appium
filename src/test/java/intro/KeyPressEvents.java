package intro;

import common_utils.DriverUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;

public class KeyPressEvents {

    @Test
    public void test(){
        AndroidDriver<AndroidElement> driver = DriverUtils.getAndroidDriver("ecommerce app");
        AndroidElement nameField = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
        nameField.click();

        boolean keyboardShown = driver.isKeyboardShown();
        System.out.println("keyboard is shown: " + keyboardShown);

        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.HOME));


        keyboardShown = driver.isKeyboardShown();
        System.out.println("keyboard is shown: " + keyboardShown);

        boolean deviceLocked = driver.isDeviceLocked();
        ScreenOrientation orientation = driver.getOrientation();

        driver.pressKey(new KeyEvent().withKey(AndroidKey.CALENDAR));
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }
}
