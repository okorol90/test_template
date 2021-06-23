package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultAndFilterPage extends BasePage{

    private By chkBoxMinPrice = By.id("low-price");
    private By chkBoxMaxPrice = By.id("high-price");
    private By btnGo = By.xpath("//input[@aria-labelledby='a-autoid-1-announce']");
    private By itemPrice = By.xpath("//span[@aria-hidden=\"true\" and ancestor::span[@class='a-price']]");
    private By itemName = By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']");

    public ResultAndFilterPage(WebDriver driver) {
        super(driver);
        log = LogManager.getLogger(ResultAndFilterPage.class);
    }

    @Override
    public BasePage open() {
        return this;
    }

    @Step("Set price for filter in range from {min} to {max}")
    public ResultAndFilterPage setPriceRangeAndClickGoBtn(String min, String max){
        driver.findElement(chkBoxMinPrice).sendKeys(min);
        driver.findElement(chkBoxMaxPrice).sendKeys(max);
        driver.findElement(btnGo).click();
        return this;
    }

    @Step("return first item from search result")
    public WebElement returnFirstItemPrice(){
        log.info("in returnFirstItemPrice()");
        return driver.findElement(itemPrice);
    }

    @Step("Return text from first item in search result")
    public String returnFirstItemPriceAsText(){
        return driver.findElement(itemPrice).getText();
    }

    @Step("return collection of element")
    public List<WebElement> returnItemsName(){
        return driver.findElements(itemName);
    }

    @Step("Return price of first element in result")
    public Float returnFirstItemPriceInFloat(){
        String firstItemPrice = driver.findElement(itemPrice).getText()
                .replace("$", "")
                .replace("\n", ".");
        return Float.valueOf(firstItemPrice);
    }
}
