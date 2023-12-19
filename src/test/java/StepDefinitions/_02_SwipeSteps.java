package StepDefinitions;

import Pages.SwipePage;
import Utilities.PageActionsHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static Utilities.DriverManager.getAppiumDriver;

public class _02_SwipeSteps {
    WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(20));
    SwipePage swipePage = new SwipePage();
    PageActionsHelper pageActionsHelper = new PageActionsHelper();

    @When("Navigate to swipe page")
    public void navigateToSwipePage() {
        getAppiumDriver().findElement(swipePage.swipeMenu).click();
    }

    @And("Scroll Down")
    public void scrollDown() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.text));
        pageActionsHelper.performScroll("down");
    }

    @Then("Logo should be visible")
    public void logoShouldBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.logo));
        Assert.assertTrue(getAppiumDriver().findElement(swipePage.logo).isDisplayed());
        if (getAppiumDriver().findElement(swipePage.logoText).isDisplayed()) {
            System.out.println("I found you!!!");
        }
    }

    @And("Scroll Right")
    public void scrollRight() {
        List list = getAppiumDriver().findElements(swipePage.allButtons);
        for (int i = 0; i < list.size(); i++) {
            pageActionsHelper.performScroll("right");
        }
    }

    @Then("Last should be visible")
    public void lastShouldBeVisible() {
        Assert.assertTrue(getAppiumDriver().findElement(swipePage.lastElement).isDisplayed());
    }
}