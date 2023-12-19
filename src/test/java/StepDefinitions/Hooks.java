package StepDefinitions;

import Utilities.DriverManager;
import io.cucumber.java.After;

public class Hooks {
    @After
    public void after() {
        DriverManager.closeApplication();
    }
}