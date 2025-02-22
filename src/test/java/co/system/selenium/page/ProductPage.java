package co.system.selenium.page;

import co.system.cucumber.glue.helpers.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends BaseTest {

    private String dashUrl = "https://rahulshettyacademy.com/client/dashboard/dash";

    @FindBy(xpath = "//div[@class = 'row']/div/div/div/h5/b")
    List<WebElement> productNames;


    public ProductPage() {
        PageFactory.initElements(getWebDriver(), this);
    }

    public void getProductNames() {

         productNames.stream().map(WebElement::getText).sorted().forEach(System.out::println);

    }



}
