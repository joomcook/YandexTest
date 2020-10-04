package testcases;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MarketHomePage;
import pages.YandexHomePage;
import util.TestUtil;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class MarketPageTest extends TestBase {

    TestUtil testutil;

    @BeforeTest
    public void beforeTestSetup() {
        initialization();
        testutil = new TestUtil();
    }

    @Test
    public void searchYandexMarkerPage() throws InterruptedException, IOException {

        String url = prop.getProperty("url");
        driver.get(url);

        YandexHomePage yhp = new YandexHomePage();
        Assert.assertTrue(yhp.verifyYandexPage(), "Yandex home page didn't loaded properly");
        Thread.sleep(2000);

        yhp.navigateToMarket();
        MarketHomePage mhp = new MarketHomePage();
        Assert.assertTrue(mhp.verifyMarketHomePage(), "Market home page didn't loaded properly");
        Thread.sleep(2000);

        String productName = testutil.convertStringToUTF("ноутбук xiaomi redmibook");

        Assert.assertTrue(mhp.fillProductTextBox(productName), "Product text box didn't fill properly");
        mhp.submitProduct();
        Thread.sleep(2000);

        Assert.assertTrue(mhp.verifySearchResults(),"Search results didn't load properly");
        Thread.sleep(2000);

        Assert.assertTrue(mhp.checkMyRegion(), "Checkbox didn't select");
        Thread.sleep(2000);

        Assert.assertTrue(mhp.verifySearchResultsAfterCheck(), "Search results didn't load properly after check my region");
        Thread.sleep(5000);

        testutil.takeScreenshot();

    }

    @AfterTest
    public void afterTestSetup() {
        driver.quit();
    }

}
