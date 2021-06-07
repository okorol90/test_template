package webtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AmazonHighlightTest extends TestBase{

    String search = "some search";


    @Test
    public void HighlightTest(){
        By navBarBox = By.id("nav-search-bar-form");
        By navBarInput = By.id("twotabsearchtextbox");

        driver.findElement(navBarInput).click();
        driver.findElement(navBarInput).sendKeys(search);
        String color = driver.findElement(navBarBox).getCssValue("border-color");
        String textInBox = driver.findElement(navBarInput).getAttribute("value");
        driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_0']")).click();

        Assert.assertEquals(color,"rgb(15, 17, 17)");
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
