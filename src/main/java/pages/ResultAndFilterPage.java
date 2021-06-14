package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultAndFilterPage extends BasePage{

    private By chkBoxMinPrice = By.id("low-price");
    private By chkBoxMaxPrice = By.id("high-price");
    private By btnGo = By.xpath("//input[@aria-labelledby='a-autoid-1-announce']");
    private By itemPrice = By.xpath("//span[@aria-hidden=\"true\" and ancestor::span[@class='a-price']]");

    public ResultAndFilterPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public BasePage open() {
        return this;
    }

    public ResultAndFilterPage setPriceRangeAndClickGoBtn(String min, String max){
        driver.findElement(chkBoxMinPrice).sendKeys(min);
        driver.findElement(chkBoxMaxPrice).sendKeys(max);
        driver.findElement(btnGo).click();
        return this;
    }

    public WebElement returnFirstItemPrice(){
        return driver.findElement(itemPrice);
    }

    public String returnFirstItemPriceAsText(){
        return driver.findElement(itemPrice).getText();
    }

    public Float returnFirstItemPriceInFloat(){
        String firstItemPrice = driver.findElement(itemPrice).getText()
                .replace("$", "")
                .replace("\n", ".");
        return Float.valueOf(firstItemPrice);
    }
}
