package pages;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

        if (YandexPageTitle.equals("Яндекс")) {
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
