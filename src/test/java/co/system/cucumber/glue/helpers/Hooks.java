package co.system.cucumber.glue.helpers;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hooks extends BaseTest {

    public Hooks() {
    }

    @Before
    public void beforeScenario(Scenario scenario) throws IOException {
        BaseTest.initializeDriver();
        currentScenario = scenario;  // Store the scenario for later use
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = takeScreenshot(scenario.getName()).getBytes();
            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }
        getWebDriver().quit();
    }

}
