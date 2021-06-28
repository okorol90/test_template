package webtest;

import io.qameta.allure.Description;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultAndFilterPage;
import pages.TodaysDealsPage;

import java.util.List;

public class SearchTest extends TestBase{

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
    public void verifySearch(String search, int amount) throws Exception {
        homePage.open()
                .search(search);
        List<WebElement> lst = resultAndFilterPage.returnItemsName();

        Assert.assertTrue(lst.size()> amount);
    }

    @Test
    @Description("Check price items more than 19")
    public void verifySearchXiaomi() throws Exception {
        homePage.open()
                .search("Xiaomi");
        List<WebElement> lst = resultAndFilterPage.returnItemsName();

        Assert.assertTrue(lst.size()> 15);
    }
}
