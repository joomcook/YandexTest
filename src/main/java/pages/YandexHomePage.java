package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Set;


public class YandexHomePage extends TestBase {

    @FindBy(xpath = "//a[contains(@href,'market.yandex.ru')]")
    WebElement marketLink;

    public YandexHomePage()  {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyYandexPage() {
        String YandexPageTitle;

        YandexPageTitle = driver.getTitle();
        ByteBuffer YandexPageTitleUTF8 = StandardCharsets.UTF_8.encode(YandexPageTitle);
        ByteBuffer YandexPageTitleToCompareUTF8 = StandardCharsets.UTF_8.encode("Яндекс");

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
