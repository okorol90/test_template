import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultAndFilterPage;
import pages.TodaysDealsPage;
import webtest.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CollExample extends TestBase {

        String search1 = "Samsung";
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
        public void getOnlyIphoneInResult() throws Exception {
            homePage.open()
                    .search(search1);
            List<WebElement> lstSam = resultAndFilterPage.returnItemsName();
            homePage
                    .search(search2);
            List<WebElement> lstIph = resultAndFilterPage.returnItemsName();

            System.out.println(lstIph.size());
            lstIph.removeAll(lstSam);
            System.out.println(lstIph.size());

            List<String> itemText = new ArrayList<>();

            for (WebElement el:lstIph) {
                itemText.add(el.getText());
            }

            itemText.forEach(System.out::println);

            for (String a:itemText) {
                Assert.assertTrue(a.toLowerCase(Locale.ROOT).contains("iphone"), "Doesn't contain "+a);
            }

        }

    }
