package util;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/cucumber/features",
        glue = {"co.system.cucumber.glue", "util"},  // Include both glue packages
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = "@Run"  // Execute only scenarios or features with the @Run tag
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {


}