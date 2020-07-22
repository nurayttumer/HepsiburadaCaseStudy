package pages;

import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.ArrayList;
import java.util.List;

import static base.PageBase.WAIT_TIME;

public class CheckProductCount extends TestBase {

    RemoteWebDriver driver;

    public CheckProductCount(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);

    }

    public CheckProductCount goToUrl() {
        driver.get("https://www.hepsiburada.com/markalar");
        System.out.println("Go to url is done");

        return this;

    }

    public CheckProductCount goToN() {
        driver.findElement(By.linkText("N")).click();
        System.out.println("Go to N");

        return this;
    }

    public CheckProductCount goToNikeAndCheckProductCount() throws InterruptedException {
        List<WebElement> elementName = driver.findElements(By.cssSelector(".brand-name"));
        List<WebElement> productCount = driver.findElements(By.cssSelector(".brand-length"));
        String countInAllBrands = null;

        int listsize = elementName.size();
        for (int i = 0; i < listsize; i++) {
            if (elementName.get(i).getText().equals("Nike")) {

                System.out.println(i + "=index of Nike");
                Thread.sleep(3000);
                countInAllBrands = productCount.get(i).getText();
                scrollToElement(driver,elementName.get(i));
                elementName.get(i).click();
                Thread.sleep(3000);
                System.out.println("Go to Nike");
                break;
            }
        }

        WebElement countTextInNike = driver.findElement(By.cssSelector("div#productResult div.title-wrapper.with-bg.for-desktop.brand > div > div > div"));
        String countInNike = countTextInNike.getText();
        String replacedCountInNike= countInNike.replace("." , "").replace(" ürün var","");
        String replacedcountInAllBrands = countInAllBrands.replace(" Ürün", "");
        Assert.assertEquals(replacedcountInAllBrands, replacedCountInNike);
        System.out.println("Check product counts in brands page and brand detail page");

        return this;
    }

}