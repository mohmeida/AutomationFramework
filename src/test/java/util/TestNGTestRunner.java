package util;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/cucumber/features",
        glue = "co.system.cucumber.glue",  // This should include the package containing BaseTest
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class TestNGTestRunner extends AbstractTestNGCucumberTests {


}