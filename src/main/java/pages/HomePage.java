package pages;

import org.apache.log4j.LogManager;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
        log = LogManager.getLogger(HomePage.class);
    }

    @Override
    public HomePage open() {
        log.info("in HomePage");
        driver.get("https://www.amazon.com/");
        return this;
    }


}
