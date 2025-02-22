package co.system.selenium.page;

import co.system.cucumber.glue.helpers.BaseTest;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    private String dashUrl = "https://rahulshettyacademy.com/client/dashboard/dash";

    @FindBy(xpath = "//input[@id='userEmail']")
    WebElement userEmail;

    @FindBy(css = "input[id='userPassword']")
    WebElement passWord;

    @FindBy(id = "login")
    WebElement loginBtn;


    public LoginPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    public void goToUrl() {
        getWebDriver().get("https://rahulshettyacademy.com/client");
    }

    public void enterUsernameAndPassword(String username, String password) {
        waitForWebElementToAppear(userEmail);
        userEmail.sendKeys(username);
        waitForWebElementToAppear(passWord);
        passWord.sendKeys(password);
        waitForWebElementToAppear(loginBtn);
        loginBtn.click();
    }

    public void verifySuccessLogin(){
        waitForUrlToContain(dashUrl);
        Assertions.assertThat(getWebDriver().getCurrentUrl()).contains(dashUrl);
    }
}
