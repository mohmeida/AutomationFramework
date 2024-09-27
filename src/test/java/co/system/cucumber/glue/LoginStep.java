package co.system.cucumber.glue;

import co.system.selenium.page.LoginPage;
import io.cucumber.java.en.*;
import co.system.cucumber.glue.helpers.BaseTest;

import java.util.Map;

import static co.system.cucumber.glue.helpers.BaseTest.resolveData;
import static util.RetryUtils.doWithRetry;


public class LoginStep {

    protected LoginPage loginPage;
    protected BaseTest baseTest;

    public LoginStep() {
        loginPage = new LoginPage();
    }

    @Given("Launch Portal")
    public void launchPortal() {
        loginPage.goToUrl();
    }

    @Given("User Logins to system with username {string} and password {string}")
    public void userLoginsToSystemWithUsernameAndPassword(String username, String password) {
        System.out.printf(username, password);
    }

    @Given("User Logins to system with below data:")
    public void userLoginsToSystemWithBelowData(Map<String, String> data)  {

        //use resolveData method to fetch data from properties file
        String email = resolveData(data.get("useremail"));
        String password = resolveData(data.get("password"));

        //Use Runnable interface to run method so it can be used for retry
        Runnable loginToSystem = () -> loginPage.enterUsernameAndPassword(email, password);

        // Call the retry method
        doWithRetry(loginToSystem, "Enter Username and Password", 3, 2000);

    }

    @When("verifies user was able to successfully login")
    public void verifiesUserWasAbleToSuccessfullyLogin() {
        loginPage.verifySuccessLogin();
    }
}
