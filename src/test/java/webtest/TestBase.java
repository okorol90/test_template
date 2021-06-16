package webtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ScreenShoot;

public class TestBase {
    protected ChromeOptions options;
    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeMethod
    public void setUp(ITestContext result) {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        result.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        driver.quit();
    }
}
