package pages;

import common_utils.DriverUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class EcomAppHomePage {

    public EcomAppHomePage(AndroidDriver<AndroidElement> driver){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    public AndroidElement nameField;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
    public AndroidElement letsShopButton;

    public void login(String name){
        nameField.sendKeys(name);
        letsShopButton.click();
    }

}
