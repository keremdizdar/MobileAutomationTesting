package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static Utilities.DriverManager.getAppiumDriver;

public class FormsPage {
    public FormsPage() {
        PageFactory.initElements(getAppiumDriver(), this);
    }

    public AppiumBy formsButton = (AppiumBy) AppiumBy.accessibilityId("Forms");
    public AppiumBy dropdown = (AppiumBy) AppiumBy.accessibilityId("Dropdown");
    public By secondOption = By.xpath("//*[@text='Appium is awesome']");
    public By actualSelectedOption = By.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]/android.view.ViewGroup/android.widget.EditText");
    public AppiumBy switchText = (AppiumBy) AppiumBy.accessibilityId("switch-text");
    public AppiumBy switchButton = new AppiumBy.ByAccessibilityId("switch");
}