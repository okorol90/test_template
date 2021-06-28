package webtest;

import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultAndFilterPage;
import pages.TodaysDealsPage;

import java.util.List;

@Epic("Result list")
@Story("Check price")
@Link("http://amazon.com")
@TmsLink("AS-1016")
public class PositiveTest extends TestBase {
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

    @Test
    @Description("Check price items more than 19")
    public void getOnlyIphoneInResult11() throws Exception {
        homePage.open()
                .search(search2);
        List<WebElement> lst = resultAndFilterPage.returnItemsName();

        Assert.assertTrue(lst.size()> 19);

    }
}