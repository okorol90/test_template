package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import utils.PropertyLoader;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
        log = LogManager.getLogger(HomePage.class);
    }

    @Override
    public HomePage open() {
        log.info("in HomePage");
        driver.get(PropertyLoader.getProperty("baseUrl"));
        return this;
    }


}
