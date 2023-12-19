package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static Utilities.DriverManager.getAppiumDriver;

public class DragPage {
    public DragPage() {
        PageFactory.initElements(getAppiumDriver(), this);
    }

    public AppiumBy dragMenu = (AppiumBy) AppiumBy.accessibilityId("Drag");
    public By congrats = By.xpath("//*[@text='Congratulations']");
    public AppiumBy retry = new AppiumBy.ByAccessibilityId("button-Retry");
}