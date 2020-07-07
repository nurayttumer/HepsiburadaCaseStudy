package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static base.PageBase.IMPLICITYLY_WAIT;
import static base.PageBase.WAIT_TIME;

public class TestBase {

    public void moveElement(RemoteWebDriver driver, WebElement webElement) throws InterruptedException {
        Actions actions = new Actions(driver);
        if (PageBase.browser.equalsIgnoreCase("chrome"))
            actions.moveToElement(webElement).build().perform();
        else if (PageBase.browser.equalsIgnoreCase("firefox")) {
            int x = webElement.getLocation().getX() + (webElement.getSize().getWidth() / 2);
            int y = webElement.getLocation().getY() + (webElement.getSize().getHeight() / 2);

            try {
                actions.moveByOffset(x, y).build().perform();
            } catch (MoveTargetOutOfBoundsException e) {
                scrollToElement(driver, webElement);
                actions.moveToElement(webElement).build().perform();
            }

            Thread.sleep(500);
        }
    }

    public void scrollToElement(RemoteWebDriver driver, WebElement webElement) {
        javascriptExecutor(driver).executeScript("window.scrollTo(" + webElement.getLocation().x + "," + webElement.getLocation().y + ");");
    }

    public WebDriverWait wait(RemoteWebDriver driver) {
        return new WebDriverWait(driver, 15);
    }

//    public void waitForInvisibilityOfAllElements(RemoteWebDriver driver, WebElement webElement) {
//        wait(driver).until(ExpectedConditions.invisibilityOfAllElements(webElement));
//    }

//    public void waitForElementToBeClickable(RemoteWebDriver driver, WebElement webElement) {
//        wait(driver).until(ExpectedConditions.elementToBeClickable(webElement));
//    }


    public boolean isElementPresent(RemoteWebDriver driver, By by) {
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MICROSECONDS);
        if (driver.findElements(by).size() > 0) {
            driver.manage().timeouts().implicitlyWait(IMPLICITYLY_WAIT, TimeUnit.MICROSECONDS);
            return true;
        } else {
            driver.manage().timeouts().implicitlyWait(IMPLICITYLY_WAIT, TimeUnit.MICROSECONDS);
            return false;
        }
    }

    public JavascriptExecutor javascriptExecutor(RemoteWebDriver driver) {
        return driver;
    }

    public boolean isChecked(RemoteWebDriver driver, String cssSelector, int index) {
        return Boolean.parseBoolean(javascriptExecutor(driver).executeScript("return document.querySelectorAll(\"" + cssSelector + "\")[" + index + "].checked;").toString());
    }

    public void clickElementWithJS(RemoteWebDriver driver, WebElement element) {

        javascriptExecutor(driver).executeScript("arguments[0].click();", element);
    }

    public static void waitForDOMLoad(RemoteWebDriver driver) {
        try {
            JavascriptExecutor js = driver;
            Boolean readyState;
            Boolean jqueryDefined;
            for (int i = 0; i <= 60; i++) {
                readyState = js.executeScript("return document.readyState").toString() != "complete";
                jqueryDefined = js.executeScript("return typeof jQuery").toString() != "function";

                if (readyState && jqueryDefined) {
                    break;
                } else {
                    Thread.sleep(100);
                }
            }

        } catch (Exception e) {
            try {
                throw e;
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }

    public String createTestName() {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String fullname = "";
        for (int i = 0; i <= 10; i++) {
            Random random = new Random();
            fullname = fullname + alphabet[random.nextInt(alphabet.length - 1)];
        }
        return "Test " + fullname;
    }
}
