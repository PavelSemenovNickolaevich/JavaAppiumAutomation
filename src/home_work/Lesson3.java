package home_work;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Lesson3 extends CoreTestCase {

    @Test
    public void testCancelSearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.skipFirstPage();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Android");
        List<WebElement> titles = SearchPageObject.getTitlesList();

        String article_titleOne = titles.get(0).getAttribute("text");
        String article_titleTwo = titles.get(1).getAttribute("text");
        String article_titleThree = titles.get(2).getAttribute("text");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Android (operating system)");
        expectedList.add("Android version history");
        expectedList.add("Android software development");
        List<String> actualList = new ArrayList<>();
        actualList.add(article_titleOne);
        actualList.add(article_titleTwo);
        actualList.add(article_titleThree);
        assertEquals(
                "We see unexpected title",
                expectedList,
                actualList
        );
        SearchPageObject.clickCancelSearch();
        SearchPageObject.assertThereIsNoListOfResults();
    }

    @Test
    public void checkWordInResult() {
        waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP element",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Adventure",
                "Cannot find search input",
                5
        );

        Boolean isContain = listOfElementsContainsWord(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Titles doesnt exist",
                5,
                "Adventure"
        );
        Assert.assertTrue("The word doesnt contain in search results", isContain);

    }

    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private List findElements(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n").until(ExpectedConditions.presenceOfElementLocated(by)); //throws a timeout exception if element not present after waiting <timeoutInSeconds> seconds
        return driver.findElements(by);
    }

    private WebElement waitForElementPresent(By by, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }

    private WebElement waitForElementPresent(By by, String message, String error_message) {
        return waitForElementPresent(by, error_message, 5);
    }


    private WebElement waitForElementAndClick(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.click();
        return element;
    }


    private WebElement waitForElementAndSendKeys(By by, String value, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;
    }


    private boolean waitForElementNotPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(by, error_message, timeoutInSeconds);
        element.clear();
        return element;

    }


    private Object assertElementHasText(By by, String expectedText, String error_message) {
        WebElement element = waitForElementPresent(by, "Element doesnt exist", 4);
        String text = element.getAttribute("text");
        if (text.contains(expectedText)) {
            return element;
        } else {
            Assert.assertEquals(error_message, expectedText, text);
            return false;
        }
    }

    private List<WebElement> listOfElements(By by, String error_message, long timeoutInSeconds) {
        List<WebElement> elements = (List<WebElement>) findElements(by, error_message, timeoutInSeconds);
        return elements;
    }

    private boolean listOfElementsContainsWord(By by, String error_message, long timeoutInSeconds, String word) {
        String text = "";
        List<WebElement> elements = (List<WebElement>) findElements(by, error_message, timeoutInSeconds);
        for (int i = 0; i < elements.size(); i++) {
            text = elements.get(i).getAttribute("text");
            if (!text.contains(word)) {
                System.out.println(text);
                return false;
            }
        }
        return true;
    }

}