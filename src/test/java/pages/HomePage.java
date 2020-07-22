package pages;

import base.PageBase;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;


public class HomePage extends TestBase {
    private RemoteWebDriver driver;

    public HomePage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, PageBase.WAIT_TIME), this);
    }

    @FindBy(css = ".logo-hepsiburada")
    public WebElement logoHepsiburada;

    @FindBy(css = "div.cookie-info > img")
    public WebElement closeCookieBaloon;

    @FindBy(css = "div#SearchBoxOld input")
    public WebElement searchBox;

    @FindBy(css = "#SearchBoxOld > div > div > div.SearchBoxOld-buttonContainer")
    public WebElement searchButton;

    @FindBy(css = "#categorySuggestionList > div.category-suggestion-title > h1")
    public WebElement searchTextKeyword;

    @FindBy(css = "body > div.wrapper > main > div.container.page-content > div > div.brands-area > a:nth-child(1011) > span.brand-name")
    public WebElement nikeText;

    public HomePage assertHomeIsLoaded() {
        System.out.println("Confirming the page is loading");
        Assert.assertTrue("logo is not displayed on homepage", logoHepsiburada.isDisplayed());
        Assert.assertEquals("https://www.hepsiburada.com/", driver.getCurrentUrl());
        return this;
    }

    public HomePage assertKeywordIsSearched() {
        searchBox.click();
        searchBox.sendKeys("IPhone");
        searchButton.click();
        Assert.assertEquals("IPhone", searchTextKeyword.getText());
        System.out.println("Confirmed the keyword is searched and equals to IPhone");
        return this;
    }

}
