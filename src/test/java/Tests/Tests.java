package Tests;

import Pages.DragPage;
import Pages.FormsPage;
import Pages.LoginPage;
import Pages.SwipePage;
import Utilities.DriverManager;
import Utilities.PageActionsHelper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Tests extends DriverManager {
    WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(20));
    LoginPage loginPage = new LoginPage();
    FormsPage formsPage = new FormsPage();
    SwipePage swipePage = new SwipePage();
    PageActionsHelper pageActionsHelper = new PageActionsHelper();
    DragPage dragPage = new DragPage();

    @Test
    public void LoginFunctionTest() {
        getAppiumDriver().findElement(loginPage.loginMenu).click();
        getAppiumDriver().findElement(loginPage.usernameInputField).sendKeys("username123@gmail.com");
        getAppiumDriver().findElement(loginPage.passwordInputField).sendKeys("parola123!");
        getAppiumDriver().findElement(loginPage.loginButton).click();
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.successfullLoginMessage)).getText();
        System.out.println(actualText);
        Assert.assertEquals(actualText, "You are logged in!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.loginOkButton)).click();
    }

    @Test
    public void dropDown() {
        getAppiumDriver().findElement(formsPage.formsButton).click();
        getAppiumDriver().findElement(formsPage.dropdown).click();
        getAppiumDriver().findElement(formsPage.secondOption).click();
        System.out.println("Selected option is = " + getAppiumDriver().findElement(formsPage.actualSelectedOption).getText());
        getAppiumDriver().findElement(formsPage.dropdown).click();
        String isSelected = getAppiumDriver().findElement(formsPage.secondOption).getAttribute("checked");
        Assert.assertEquals(isSelected, "true");
        System.out.println("Is element selected " + isSelected);
    }

    @Test
    public void Switch() {
        getAppiumDriver().findElement(formsPage.formsButton).click();
        String switchTextBeforeClick = getAppiumDriver().findElement(formsPage.switchText).getText();
        Assert.assertEquals(switchTextBeforeClick, "Click to turn the switch ON");
        System.out.println("Switch text before click = " + switchTextBeforeClick);
        Assert.assertEquals(getAppiumDriver().findElement(formsPage.switchButton).getAttribute("checked"), "false");
        Assert.assertEquals(getAppiumDriver().findElement(formsPage.switchButton).getAttribute("text"), "OFF");
        getAppiumDriver().findElement(formsPage.switchButton).click();
        Assert.assertEquals(getAppiumDriver().findElement(formsPage.switchButton).getAttribute("checked"), "true");
        Assert.assertEquals(getAppiumDriver().findElement(formsPage.switchButton).getAttribute("text"), "ON");
        String switchTextAfterClick = getAppiumDriver().findElement(formsPage.switchText).getText();
        Assert.assertEquals(switchTextAfterClick, "Click to turn the switch OFF");
        System.out.println("Switch text after click = " + switchTextAfterClick);
    }

    @Test
    public void ScrollDown() {
        getAppiumDriver().findElement(swipePage.swipeMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.text));
        pageActionsHelper.performScroll("down");
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.logo));
        Assert.assertTrue(getAppiumDriver().findElement(swipePage.logo).isDisplayed());
        if (getAppiumDriver().findElement(swipePage.logoText).isDisplayed()) {
            System.out.println("I found you!!!");
        }
    }

    @Test
    public void ScrollToRightEnd() {
        getAppiumDriver().findElement(swipePage.swipeMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.text));
        List list = getAppiumDriver().findElements(swipePage.allButtons);
        for (int i = 0; i < list.size(); i++) {
            pageActionsHelper.performScroll("right");
        }
        Assert.assertTrue(getAppiumDriver().findElement(swipePage.lastElement).isDisplayed());
    }

    @Test
    public void dragAndDrog() {
        getAppiumDriver().findElement(dragPage.dragMenu).click();
        pageActionsHelper.dragAndDrog();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dragPage.congrats));
        getAppiumDriver().findElement(dragPage.retry).click();
    }
}