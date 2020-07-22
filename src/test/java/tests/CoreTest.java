package tests;

import base.PageBase;
import org.junit.Test;
import pages.CheckProductCount;
import pages.HomePage;
import pages.ProductDetailPage;


public class CoreTest extends PageBase {

    @Test
    public void selectProductCommentAsUseful() throws Exception {
        HomePage homePage = new HomePage(driver);
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);

        homePage
                .assertHomeIsLoaded()
                .assertKeywordIsSearched();
        productDetailPage
                .goToFirstProductDetail()
                .goToComments()
                .chooseUsefulYesForFirstComment()
                .verifyThanks();
    }
    @Test
    public void checkNikeProductCount() throws Exception {
        CheckProductCount checkProductCount = new CheckProductCount(driver);
        HomePage homePage = new HomePage(driver);

        homePage
                .assertHomeIsLoaded();
        checkProductCount
                .goToUrl()
                .goToN()
                .goToNikeAndCheckProductCount();
    }

}
