package pages;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MarketHomePage extends TestBase {

    @FindBy(id = "header-search")
    WebElement searchProductTextBox;

    @FindBy(xpath = "//form//button[@type='submit']")
    WebElement searchProductButtonSubmit;

    By checkBoxMyRegionLocator = By.xpath("//label[@for='local-offers-first']//input[@type='checkbox']");
    By linkSearchResultLocator = By.xpath("//div[@data-apiary-widget-id='/content/results']//a");

    WebElement checkboxMyRegion;

    /*@FindBy(xpath = "//label[@for='local-offers-first']//input[@type='checkbox']")
    WebElement checkboxMyRegion;*/

    public MarketHomePage() {
        PageFactory.initElements(driver,this);
    }

    public boolean verifyMarketHomePage() {
       if (searchProductTextBox.isDisplayed()) {
           return true;
       }

       return false;
    }

    public boolean fillProductTextBox(String productName) {
        searchProductTextBox.sendKeys(productName);

        if(searchProductTextBox.getAttribute("value").equals(productName)) {
            return true;
        }

        return false;
    }

    public void submitProduct() {
        searchProductButtonSubmit.click();
    }

    public boolean verifySearchResults() {
        checkboxMyRegion = driver.findElement(checkBoxMyRegionLocator);

        if(checkboxMyRegion.isEnabled()) {
            return true;
        }

        return false;

    }

    public boolean checkMyRegion() {
        if(!checkboxMyRegion.isSelected()) {
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", checkboxMyRegion);
        }

        if(checkboxMyRegion.isSelected()) {
            return true;
        }

        return false;
    }

    public boolean verifySearchResultsAfterCheck() throws InterruptedException {

        int attempts = 0;
        while (attempts < 5) {
            try {
                if(driver.findElement(linkSearchResultLocator).isDisplayed()) {
                    return true;
                }

                Thread.sleep(500);
            } catch (StaleElementReferenceException e) {

            }
            attempts++;
        }

        return false;

    }
}
