package webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AmazonHighlightTest {

    ChromeOptions options;
    WebDriver driver;
    String search;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        driver.get("https://www.amazon.com/");

        search = "some search";
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void HighlightTest(){
        By navBarBox = By.id("nav-search-bar-form");
        By navBarInput = By.id("twotabsearchtextbox");

        driver.findElement(navBarInput).click();
        driver.findElement(navBarInput).sendKeys(search);
        String color = driver.findElement(navBarBox).getCssValue("border-color");
        String textInBox = driver.findElement(navBarInput).getAttribute("value");
        driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_0']")).click();

        Assert.assertEquals(color,"rgb(15, 17, 16)");
    }

    @Test
    public void test(){
        By navBarBox = By.id("nav-search-bar-form");
        By navBarInput = By.id("twotabsearchtextbox");

        driver.findElement(navBarInput).click();
        driver.findElement(navBarInput).sendKeys(search);
        String color = driver.findElement(navBarBox).getCssValue("border-color");
        String textInBox = driver.findElement(navBarInput).getAttribute("value");
        driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_0']")).click();

        List lst = new ArrayList<>();
        Assert.assertTrue(!lst.isEmpty(), "list has zero item");
    }
}
