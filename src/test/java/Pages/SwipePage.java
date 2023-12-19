package Pages;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static Utilities.DriverManager.getAppiumDriver;

public class SwipePage {
    public SwipePage() {
        PageFactory.initElements(getAppiumDriver(), this);
    }

    public AppiumBy swipeMenu = new AppiumBy.ByAccessibilityId("Swipe");
    public By text = By.xpath("//*[@text='Swipe horizontal']");
    public AppiumBy logo = new AppiumBy.ByAccessibilityId("WebdriverIO logo");
    public By logoText = By.xpath("//*[@text='You found me!!!']");
    public By allButtons = By.xpath("//android.view.ViewGroup[@content-desc=\"Carousel\"]/android.view.ViewGroup/*");
    public By lastElement = By.xpath("//*[@text='COMPATIBLE']");
}