package home_work;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Lecture4 {
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
    public void saveTwoArticles() {


        waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP element",
                1
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );


        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Cannot find search input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by 'Java'",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by 'Java'",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/article_menu_bookmark"),
                "Cannot find button to open article options",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/snackbar_action"),
                "Cannot find button ADD TO LIST",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find 'Got it' tip overlay ",
                5
        );
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                "Learning programming",
                "Cannot put text articles folder input",
                5
        );
        waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press pk button",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find arrow link",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='High-level programming language']"),
                "Cannot find OHigh-level programming language",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@text='High-level programming language']"),
                "Cannot find High-level programming language title",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/article_menu_bookmark"),
                "Cannot find button to open article options",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/snackbar_action"),
                "Cannot find button ADD TO LIST",
                5
        );

        waitForElementAndClick(
                By.id("org.wikipedia:id/item_title"),
                "Cannot find folder title",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find arrow link",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find arrow link",
                5
        );


        waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@index='0']"),
                "Cannot close article, cannot find arrow link",
                5
        );

        waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find icon",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Learning programming']"),
                "Cannot find 'Learning programming'",
                5
        );

        swipeElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article"
        );

        waitForElementNotPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot delete saved article ",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='High-level programming language']"),
                "Cannot find JS High-level programming language'",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@text='High-level programming language']"),
                "Cannot find High-level programming language title",
                5
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);


    }

    @Test
    public void assertTitle() {

        setDefaultOrientation();

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP element",
                1
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );


        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Cannot find search input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by 'Java'",
                5
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);


        assertElementPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find element - title"
        );


    }


    private WebElement waitForElementPresent(By by, String error_message, long timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    private WebElement waitForElementPresent(By by, String error_message) {
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

    protected void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);

        action.press(PointOption.point(x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe))).moveTo(PointOption.point(x, end_y)).release().perform();
    }

    protected void swipeUpQuick() {
        swipeUp(200);
    }

    protected void swipeUpToFindElement(By by, String error_message, int max_swipes) {

        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > max_swipes) {
                waitForElementPresent(by, "Cannot find element bu swiping up. \n" + error_message, 0);
                return;
            }
            swipeUpQuick();
            ++already_swiped;

        }
    }

    protected void swipeElementToLeft(By by, String error_message) {
        WebElement element = waitForElementPresent(by, error_message, 10);
        int left_x = element.getLocation().getX();
        int right_x = left_x + element.getSize().getWidth();
        int upper_y = element.getLocation().getY();
        int lower_y = upper_y + element.getSize().getHeight();
        int middle_y = (upper_y + lower_y) / 2;

        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(right_x, middle_y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
                .moveTo(PointOption.point(left_x, middle_y))
                .release()
                .perform();
    }

    private int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();

    }

    private void assetElementNotPresent(By by, String error_message) {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements > 0) {
            String default_message = "An element ' " + by.toString() + " ' supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);
        }
    }

    private String waitForElementAndGetAttribute(By by, String attribute, String error_message, long timeOutInSeconds) {

        WebElement element = waitForElementPresent(by, error_message, timeOutInSeconds);
        return element.getAttribute(attribute);
    }

    private void assertElementPresent(By by, String error_message) {
        WebElement element = getElement(by);
        if (!element.isEnabled()) {
            System.out.println(error_message);
        }
    }

    private WebElement getElement(By by) {
        WebElement element = driver.findElement(by);
        return element;
    }

    private void setDefaultOrientation() {
        ScreenOrientation orientation = driver.getOrientation();
        if (orientation == ScreenOrientation.LANDSCAPE) {
            driver.rotate(ScreenOrientation.PORTRAIT);
        }
    }
}
