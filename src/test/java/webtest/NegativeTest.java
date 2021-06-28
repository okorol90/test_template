package webtest;

import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultAndFilterPage;
import pages.TodaysDealsPage;
import utils.RetryAnalyzer;

import java.util.List;
@Epic("Result list Negative")
@Story("Check price negative")
@Feature("Unhappy scenario")
public class NegativeTest extends TestBase {
    String search2 = "iPhone";
    HomePage homePage;
    TodaysDealsPage todaysPage;
    ResultAndFilterPage resultAndFilterPage;

    @BeforeMethod
    public void setUp1() {
        homePage = new HomePage(driver);
        todaysPage = new TodaysDealsPage(driver);
        resultAndFilterPage = new ResultAndFilterPage(driver);
    }

    @Severity(SeverityLevel.MINOR)
    @Test()
    public void getOnlyIphoneInResult12() throws Exception {
        homePage.open()
                .search(search2);
        List<WebElement> lst = resultAndFilterPage.returnItemsName();

        Assert.assertEquals(lst.size(), 15);

    }

    @Severity(SeverityLevel.BLOCKER)
    @Test()
    public void getOnlyIphoneInResult13() throws Exception {
        homePage.open()
                .search("error");
        List<WebElement> lst = resultAndFilterPage.returnItemsName();

        Assert.assertEquals(lst.size(), 15);

    }
}