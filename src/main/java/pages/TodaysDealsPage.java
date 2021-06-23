package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class TodaysDealsPage extends BasePage{

    public TodaysDealsPage(WebDriver driver) {
        super(driver);
    }

    @Step
    @Override
    public TodaysDealsPage open() {
        driver.get("https://www.amazon.com/international-sales-offers/b/?ie=UTF8&node=15529609011&ref_=nav_cs_gb_intl_52df97a2eee74206a8343034e85cd058");
        return this;
    }
}
