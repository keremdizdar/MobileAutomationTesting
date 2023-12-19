package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Utilities.DriverManager.getAppiumDriver;

public class _01_LoginSteps {
    WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(20));
    LoginPage loginPage = new LoginPage();

    @Given("Open application")
    public void openApplication() {
        getAppiumDriver();
    }

    @When("Navigate to login page")
    public void navigateToLoginPage() {
        getAppiumDriver().findElement(loginPage.loginMenu).click();

    }

    @And("Enter credentials and click login button")
    public void enterCredentialsAndClickLoginButton() {
        getAppiumDriver().findElement(loginPage.usernameInputField).sendKeys("username123@gmail.com");
        getAppiumDriver().findElement(loginPage.passwordInputField).sendKeys("parola123!");
        getAppiumDriver().findElement(loginPage.loginButton).click();
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.successfullLoginMessage)).getText();
        System.out.println("Login message = " + actualText);
        Assert.assertEquals(actualText, "You are logged in!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.loginOkButton)).click();
    }
}