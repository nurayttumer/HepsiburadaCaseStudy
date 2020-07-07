package pages;

import base.TestBase;
import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;
import java.util.Random;

import static base.PageBase.IMPLICITYLY_WAIT;
import static base.PageBase.WAIT_TIME;

public class ProductDetailPage extends TestBase {

    RemoteWebDriver driver;
    String byNavigatorToCommentsSection = "a#productReviewsTab";
    String byChooseUsefulYesForFirstCommentButton = ".ReviewCard-module-34AJ_:nth-child(1) .ReviewCard-module-1MoiF > span";
    String byVerifyThanks = "div#hermes-voltran-comments div.ReviewCard-module-uH6Em > span.ReviewCard-module-1ZiTv";
    public ProductDetailPage(RemoteWebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, WAIT_TIME), this);
    }

    @FindBy(css = "div#productresults li:nth-child(2) > div > a > div > h3 > div > p > span")
    public WebElement firstItemProductName;

    @FindBy(css = "a#productReviewsTab")
    public WebElement navigatorToCommentsSection;

    @FindBy(css = ".ReviewCard-module-34AJ_:nth-child(1) .ReviewCard-module-1MoiF > span")
    public WebElement chooseUsefulYesForFirstCommentButton;

    @FindBy(css = "div#hermes-voltran-comments div.ReviewCard-module-uH6Em > span.ReviewCard-module-1ZiTv")
    public WebElement verifyThanks;

    public ProductDetailPage goToFirstProductDetail() {
        firstItemProductName.click();
        System.out.println("Product detail page is opened");
        return this;
    }
    public ProductDetailPage goToComments()  {
        Assert.assertTrue(navigatorToCommentsSection.getText().contains("Yorum"));
        isElementPresent(driver , By.cssSelector(byNavigatorToCommentsSection));
        navigatorToCommentsSection.click();
        Assert.assertFalse(navigatorToCommentsSection.getText().contains("Yorumlar (0)"));
        System.out.println("Jumped to comments section");
        return this;
    }

    public ProductDetailPage chooseUsefulYesForFirstComment()  {
        isElementPresent(driver , By.cssSelector(byChooseUsefulYesForFirstCommentButton));
        Assert.assertTrue(chooseUsefulYesForFirstCommentButton.isDisplayed());
        chooseUsefulYesForFirstCommentButton.click();
        System.out.println("First comment is choosen as useful");
        return this;
    }
    public ProductDetailPage verifyThanks()  {
        scrollToElement(driver , verifyThanks);
        isElementPresent(driver , By.cssSelector(byVerifyThanks));
        Assert.assertTrue(verifyThanks.isDisplayed());
        Assert.assertTrue(verifyThanks.getText().equals("Teşekkür Ederiz."));
        System.out.println("Thanks text is verified");
        return this;
    }
}
