package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.TestUtil;

import java.util.Set;


public class YandexHomePage extends TestBase {

    @FindBy(xpath = "//a[contains(@href,'market.yandex.ru')]")
    WebElement marketLink;

    TestUtil testUtil;

    public YandexHomePage()  {
        testUtil = new TestUtil();
        PageFactory.initElements(driver,this);
    }

    public boolean verifyYandexPage() {
        String YandexPageTitle;

        String YandexPageTitleUTF8 = testUtil.convertStringToUTF(driver.getTitle());
        String YandexPageTitleToCompareUTF8 = testUtil.convertStringToUTF("Яндекс");

        if (YandexPageTitleUTF8.equals(YandexPageTitleToCompareUTF8)) {
            return true;
        }

        return false;

    }

    public void navigateToMarket() {
        String parentWindow = driver.getWindowHandle();

        marketLink.click();

        Set<String> handles=driver.getWindowHandles();

        for(String winHandle : handles){
            if(!winHandle.equals(parentWindow)) {
                driver.switchTo().window(winHandle);
            }
        }

    }
}
