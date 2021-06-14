package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private final By btnLanFlag = By.id("icp-nav-flyout");
    private final By navBarInput = By.id("twotabsearchtextbox");
    private String locatorLang = "//div[@id='nav-flyout-icp']//a[descendant::span[contains(text(), '%s')]]";

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;


    protected BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
    }

    protected abstract BasePage open();

    public BasePage selectLanguage(String language){
        actions.moveToElement(driver.findElement(btnLanFlag)).perform();
        By lang = By.xpath(String.format(locatorLang, language));
        wait.until(ExpectedConditions.elementToBeClickable(lang)).click();
        return this;
    }

    public BasePage search(String search){
        driver.findElement(navBarInput).click();
        driver.findElement(navBarInput).clear();
        driver.findElement(navBarInput).sendKeys(search, Keys.ENTER);
        return this;
    }

}
