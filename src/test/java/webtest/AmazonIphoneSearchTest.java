package webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;

public class AmazonIphoneSearchTest extends TestBase{

    String search;

    @BeforeMethod
    public void setUp1(){
        search = "iPhone";
    }

    @Test
    public void getPriceInRange() throws InterruptedException {
        By btnLanFlag = By.id("icp-nav-flyout");
        By btnEn = By.xpath("//div[@id='nav-flyout-icp']//a[descendant::span[contains(text(), 'English - EN')]]");
        By btnDe = By.xpath("//div[@id='nav-flyout-icp']//a[descendant::span[contains(text(), 'Deutsch - DE')]]");


        By navBarInput = By.id("twotabsearchtextbox");
        By chkBoxMinPrice = By.id("low-price");
        By chkBoxMaxPrice = By.id("high-price");
        By btnGo = By.xpath("//input[@aria-labelledby='a-autoid-1-announce']");
//        By item = By.xpath("//div[@data-component-type='s-search-result' and descendant::span[@class='a-price']]");
        By itemPrice = By.xpath("//span[@aria-hidden=\"true\" and ancestor::span[@class='a-price']]");

        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(btnLanFlag)).perform();
        Thread.sleep(2000);
        driver.findElement(btnDe).click();
        Thread.sleep(2000);
        actions.moveToElement(driver.findElement(btnLanFlag)).perform();
        Thread.sleep(2000);
        driver.findElement(btnEn).click();


        driver.findElement(navBarInput).click();
        driver.findElement(navBarInput).sendKeys(search, Keys.ENTER);
        driver.findElement(chkBoxMinPrice).sendKeys("100");
        driver.findElement(chkBoxMaxPrice).sendKeys("150");
        driver.findElement(btnGo).click();
        String firstItemPrice = driver.findElement(itemPrice).getText().replace("$", "").replace("\n", ".");
        Float priceInFloat = Float.valueOf(firstItemPrice);

        Assert.assertTrue(priceInFloat > 100 && priceInFloat < 150, "Price isn't in range "+priceInFloat);
    }
}