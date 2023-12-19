package StepDefinitions;

import Pages.FormsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static Utilities.DriverManager.getAppiumDriver;

public class _03_FormsSteps {
    FormsPage formsPage = new FormsPage();

    @When("Navigate to forms page")
    public void navigateToFormsPage() {
        getAppiumDriver().findElement(formsPage.formsButton).click();
    }

    @When("User turns on switch")
    public void userTurnsOnSwitch() {
        String switchTextBeforeClick = getAppiumDriver().findElement(formsPage.switchText).getText();
        Assert.assertEquals(switchTextBeforeClick, "Click to turn the switch ON");
        System.out.println("Switch text before click = " + switchTextBeforeClick);
        Assert.assertEquals(getAppiumDriver().findElement(formsPage.switchButton).getAttribute("checked"), "false");
        Assert.assertEquals(getAppiumDriver().findElement(formsPage.switchButton).getAttribute("text"), "OFF");
        getAppiumDriver().findElement(formsPage.switchButton).click();
    }

    @Then("Switch should be turned on")
    public void switchShouldbeTurnedOn() {
        Assert.assertEquals(getAppiumDriver().findElement(formsPage.switchButton).getAttribute("checked"), "true");
        Assert.assertEquals(getAppiumDriver().findElement(formsPage.switchButton).getAttribute("text"), "ON");
        String switchTextAfterClick = getAppiumDriver().findElement(formsPage.switchText).getText();
        Assert.assertEquals(switchTextAfterClick, "Click to turn the switch OFF");
        System.out.println("Switch text after click = " + switchTextAfterClick);
    }

    @When("User opens drowdown menu")
    public void userOpensDrowdownMenu() {
        getAppiumDriver().findElement(formsPage.dropdown).click();

    }

    @And("Select second option")
    public void selectSecondOption() {
        getAppiumDriver().findElement(formsPage.secondOption).click();
    }

    @Then("Second option should be selected")
    public void secondOptionShouldBeSelected() {
        System.out.println("Selected option is = " + getAppiumDriver().findElement(formsPage.actualSelectedOption).getText());
        getAppiumDriver().findElement(formsPage.dropdown).click();
        String isSelected = getAppiumDriver().findElement(formsPage.secondOption).getAttribute("checked");
        Assert.assertEquals(isSelected, "true");
        System.out.println("Is element selected " + isSelected);
    }
}