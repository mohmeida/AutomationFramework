package co.system.cucumber.glue;

import co.system.selenium.page.ProductPage;
import io.cucumber.java.en.Given;

import static util.RetryUtils.doWithRetry;

public class ProductsSteps {

    ProductPage productPage;

    public ProductsSteps() {
        productPage = new ProductPage();
    }

    @Given("I fetch the product names")
    public void iFetchTheProductNames() {
        //Use Runnable interface to run method so it can be used for retry
        Runnable getProductNames = () -> productPage.getProductNames();

        // Call the retry method
        doWithRetry(getProductNames, "Get Product Names", 3, 2000);

    }
}
