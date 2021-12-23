package step_definitions;

import common_utils.DriverUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class EcomLoginStepDefs {

    AndroidDriver<AndroidElement> driver;

    @When("user logs in with valid name")
    public void user_logs_in_with_valid_name() {
        driver = DriverUtils.getAndroidDriver("ecommerce app");
        AndroidElement nameField = driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
        nameField.sendKeys("cigdem");
        AndroidElement letsShopButton = driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
        DriverUtils.tap(driver, letsShopButton);
    }
    @Then("user should see list of items")
    public void user_should_see_list_of_items() {
        List<AndroidElement> productList = driver.findElements(By.id("com.androidsample.generalstore:id/rvProductList"));
        System.out.println(productList);
        Assert.assertEquals("Air Jordan 4 Retro", productList.get(0).getText());
    }
}
