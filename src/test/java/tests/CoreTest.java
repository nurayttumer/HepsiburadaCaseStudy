package tests;

import base.PageBase;
import org.junit.Test;
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


}
