package webtest;

import io.qameta.allure.Attachment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    protected ChromeOptions options;
    protected WebDriver driver;
    protected WebDriverWait wait;


    @BeforeMethod
    public void setUp(ITestContext result) throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");
//        driver = new ChromeDriver(options);
        driver = new RemoteWebDriver(new URL(PropertyLoader.getProperty("driverUrl")), options);
        result.setAttribute("driver", driver);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        driver.quit();
    }


}
