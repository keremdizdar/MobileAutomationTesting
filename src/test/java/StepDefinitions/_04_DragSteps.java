package StepDefinitions;

import Pages.DragPage;
import Utilities.PageActionsHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utilities.DriverManager.getAppiumDriver;

public class _04_DragSteps {
    WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(20));
    DragPage dragPage = new DragPage();
    PageActionsHelper pageActionsHelper = new PageActionsHelper();

    @When("Navigate to drag page")
    public void navigate_to_drag_page() {
        getAppiumDriver().findElement(dragPage.dragMenu).click();
    }

    @When("User completes drag and drop")
    public void user_completes_drag_and_drop() {
        pageActionsHelper.dragAndDrog();

    }

    @Then("Success message should be displayed")
    public void success_message_should_be_displayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dragPage.congrats));
        getAppiumDriver().findElement(dragPage.retry).click();
    }
}