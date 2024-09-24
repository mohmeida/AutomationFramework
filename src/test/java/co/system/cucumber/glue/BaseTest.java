package co.system.cucumber.glue;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {

    protected static WebDriver driver;

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartHeader;

    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHeader;

    public BaseTest() {
    }

    public static WebDriver initializeDriver() throws IOException

    {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "//src//test//resources//"+ System.getenv("QA_ENV") +".properties");
        prop.load(fis);

        String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");

        if (browserName.contains("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
			if(browserName.contains("headless")){
			options.addArguments("headless");
			}
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));//full screen

        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    "/Users/rahulshetty//documents//geckodriver");
            driver = new FirefoxDriver();
            // Firefox
        } else if (browserName.equalsIgnoreCase("edge")) {
            // Edge
            System.setProperty("webdriver.edge.driver", "edge.exe");
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public static String resolveData(String key)
    {
        //read json to string
        Properties prop = new Properties();
        FileInputStream fis;
        try {
            fis = new FileInputStream(System.getProperty("user.dir")
                    + "//src//test//resources//"+ System.getenv("QA_ENV") +".properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(key);
    }

    public WebDriver getWebDriver() {
        return driver;
    }


    public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";


    }

    public void waitForElementToAppear(By findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public void waitForWebElementToAppear(WebElement findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }

    public void waitForUrlToContain(String partialUrl) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // wait for up to 10 seconds
        wait.until(ExpectedConditions.urlContains(partialUrl)); // Wait until URL contains the substring
    }

    @Before
    public void launchApplication() throws IOException
    {
        driver = initializeDriver();
    }

    @After()
    public void tearDown()
    {
        driver.quit();
    }
}
