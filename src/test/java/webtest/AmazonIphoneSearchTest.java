package webtest;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class AmazonIphoneSearchTest extends TestBase {

    String search;
    ExpectedCondition custom;

    @BeforeMethod
    public void setUp1() {
        search = "iPhone";
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    @Test
    public void getPriceInRange() throws InterruptedException {
        By btnLanFlag = By.id("icp-nav-flyout");
        By btnEn = By.xpath("//div[@id='nav-flyout-icp']//a[descendant::span[contains(text(), 'English - EN')]]");
        By btnDe = By.xpath("//div[@id='nav-flyout-icp']//a[descendant::span[contains(text(), 'Deutsch - DE')]]");
        By btnEs = By.xpath("//div[@id='nav-flyout-icp']//a[descendant::span[contains(text(), 'Español - ES')]]");


        By navBarInput = By.id("twotabsearchtextbox");
        By chkBoxMinPrice = By.id("low-price");
        By chkBoxMaxPrice = By.id("high-price");
        By btnGo = By.xpath("//input[@aria-labelledby='a-autoid-1-announce']");
//        By item = By.xpath("//div[@data-component-type='s-search-result' and descendant::span[@class='a-price']]");
        By itemPrice = By.xpath("//span[@aria-hidden=\"true\" and ancestor::span[@class='a-price']]");
//        Thread.sleep(10000);
//        driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_1']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-csa-c-slot-id='nav_cs_1']"))).click();

//        wait.until(ExpectedConditions
//                .textToBePresentInElementLocated(By.xpath("//a[@data-csa-c-slot-id='nav_cs_1']"), "Customer123 Service"));


//        driver.findElement(navBarInput).sendKeys(search);
//        wait.until(ExpectedConditions.attributeToBe(navBarInput, "value", search+"error"));

//        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@id, 'desktop-grid-')]"), 5));
//        setCustom(btnEn);
//        wait.until(custom);
//        setCustom(btnEs);
//        wait.until(custom);
//        setCustom(btnDe);
//        wait.until(custom);

//        wait.until(dr-> dr.findElements(By.xpath("//div[contains(@id, 'desktop-grid-')]")).size() == 5);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(btnLanFlag)).perform();

        wait.until(ExpectedConditions
                .and(ExpectedConditions.presenceOfElementLocated(btnDe), ExpectedConditions.presenceOfElementLocated(btnEs)));
//        wait.until(ExpectedConditions
//                .or(ExpectedConditions.presenceOfElementLocated(btnEn), ExpectedConditions.presenceOfElementLocated(btnDe)));


        driver.findElement(btnDe).click();

        actions.moveToElement(driver.findElement(btnLanFlag)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(btnEn)).click();


        driver.findElement(navBarInput).click();
        driver.findElement(navBarInput).sendKeys(search, Keys.ENTER);
        driver.findElement(chkBoxMinPrice).sendKeys("100");
        driver.findElement(chkBoxMaxPrice).sendKeys("150");
        driver.findElement(btnGo).click();

        String firstItemPrice = driver.findElement(itemPrice).getText().replace("$", "").replace("\n", ".");
        Float priceInFloat = Float.valueOf(firstItemPrice);

        Assert.assertTrue(priceInFloat > 100 && priceInFloat < 150, "Price isn't in range " + priceInFloat);
    }

    private void setCustom(By by){
        custom = new ExpectedCondition<Boolean>() {
            @NullableDecl
            @Override
            public Boolean apply(@NullableDecl WebDriver webDriver) {
                if(by.toString().contains("EN")){
                    System.out.println("if");
                    return true;
                } else if(by.toString().contains("ES")){
                    System.out.println("else if");
                    return true;
                }else {
                    System.out.println("else");
                    return 1<2;
                }
            }
        };
    }
}