package webtest;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ResultAndFilterPage;
import pages.TodaysDealsPage;

public class AmazonIphoneSearchTest extends TestBase {

    String search1 = "Samsung";
    String search2 = "iPhone";
    ExpectedCondition custom;
    HomePage homePage;
    TodaysDealsPage todaysPage;
    ResultAndFilterPage resultAndFilterPage;

    @BeforeMethod
    public void setUp1() {
        homePage = new HomePage(driver);
        todaysPage = new TodaysDealsPage(driver);
        resultAndFilterPage = new ResultAndFilterPage(driver);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
//        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

    @Test
    public void getPriceInRange() throws Exception {
        homePage.open()
                .selectLanguage("Deutsch - DE")
                .search(search1);
        resultAndFilterPage.setPriceRangeAndClickGoBtn("100", "150")
                .selectLanguage("English - EN")
                .search(search2);
        resultAndFilterPage.setPriceRangeAndClickGoBtn("100", "150");

        System.out.println(resultAndFilterPage.returnFirstItemPrice().getSize());
        System.out.println(resultAndFilterPage.returnFirstItemPriceAsText());

        Float priceInFloat = resultAndFilterPage.returnFirstItemPriceInFloat();
        Assert.assertTrue(priceInFloat > 100 && priceInFloat < 150, "Price isn't in range " + priceInFloat);


//        By item = By.xpath("//div[@data-component-type='s-search-result' and descendant::span[@class='a-price']]");
//        wait.until(ExpectedConditions
//                .or(ExpectedConditions.presenceOfElementLocated(btnEn), ExpectedConditions.presenceOfElementLocated(btnDe)));
//        Thread.sleep(10000);
//        driver.findElement(By.xpath("//a[@data-csa-c-slot-id='nav_cs_1']")).click();
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-csa-c-slot-id='nav_cs_1']"))).click();

//        wait.until(ExpectedConditions
//                .textToBePresentInElementLocated(By.xpath("//a[@data-csa-c-slot-id='nav_cs_1']"), "Customer123 Service"));


//        driver.findElement(navBarInput).sendKeys(search);
//        wait.until(ExpectedConditions.attributeToBe(navBarInput, "value", search+"error"));

//        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@id, 'desktop-grid-')]"), 5));
//        setCustom(btnEn);
//        wait.until(custom);
//        setCustom(btnEs);
//        wait.until(custom);
//        setCustom(btnDe);
//        wait.until(custom);

//        wait.until(dr-> dr.findElements(By.xpath("//div[contains(@id, 'desktop-grid-')]")).size() == 5);
    }

//    private void setCustom(By by){
//        custom = new ExpectedCondition<Boolean>() {
//            @NullableDecl
//            @Override
//            public Boolean apply(@NullableDecl WebDriver webDriver) {
//                if(by.toString().contains("EN")){
//                    System.out.println("if");
//                    return true;
//                } else if(by.toString().contains("ES")){
//                    System.out.println("else if");
//                    return true;
//                }else {
//                    System.out.println("else");
//                    return 1<2;
//                }
//            }
//        };
//    }
}