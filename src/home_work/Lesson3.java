package home_work;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Lesson3 {

    private AppiumDriver driver;

    @Before
    public void setUp() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:/Users/Paul/Desktop/JavaAppiumAutomation/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void fistTest() throws InterruptedException {

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


        assertElementHasText(
                By.id("org.wikipedia:id/search_src_text"),
                "Search Wikipedia",
                "Text doesnt exist"
        );

    }

    @Test
    public void cancelSearch() {

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
                "Android",
                "Cannot find search input",
                5
        );

        List<WebElement> titles = listOfElements(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Titles doesnt exist",
                10
        );

        String article_titleOne = titles.get(0).getAttribute("text");
        String article_titleTwo = titles.get(1).getAttribute("text");
        String article_titleThree = titles.get(2).getAttribute("text");

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Android");
        expectedList.add("Android (operating system)");
        expectedList.add("Android version history");
        List<String> actualList = new ArrayList<>();
        actualList.add(article_titleOne);
        actualList.add(article_titleTwo);
        actualList.add(article_titleThree);
        Assert.assertEquals(
                "We see unexpected title",
                expectedList,
                actualList
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/search_close_btn"),
                "Element doesnt exist",
                5
        );

        waitForElementNotPresent(
                By.id("org.wikipedia:id/page_list_item_title"),
                "Titles exist!!!",
                10
        );

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
        List<WebElement> elements = (List<WebElement>) findElements(by, error_message, timeoutInSeconds);
        for(int i = 0; i < elements.size(); i++) {
            String text = elements.get(i).getAttribute("text");
            if (text.contains(word)){
                return true;
            }
        }
        return false;
    }



}