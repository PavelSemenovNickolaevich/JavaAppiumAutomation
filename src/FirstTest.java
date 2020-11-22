import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Assert;
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

public class FirstTest {
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
                1
        );

        waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );

        waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Java",
                "Cannot find search input",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by 'Java'",
                15);
    }

    @Test
    public void testCancelSearch() throws InterruptedException {

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
                By.className("android.widget.FrameLayout"),
                "Java",
                "Cannot find search input",
                5
        );

        waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot search field",
                5
        );


        waitForElementAndClick(
                By.className("android.widget.ImageButton"),
                "Cannot find search input",
                5
        );


        waitForElementNotPresent(
                By.className("android.widget.ImageButton"),
                "Back is still on the page",
                5
        );

    }

    @Test
    public void testCompareArticleTitle() {

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
                By.className("android.widget.FrameLayout"),
                "Java",
                "Cannot find search input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by 'Java'",
                5
        );

        WebElement title_element = waitForElementPresent(
                By.xpath("//*[@content-desc='Java (programming language)']"),
                "Cannot find OOP language by 'Java'",
                5
        );

        String article_title = title_element.getAttribute("name");
        Assert.assertEquals(
                "We see unexpected title",
                "Java (programming language)",
                article_title
        );
    }

    @Test
    public void testSwipeArticle() {

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

//        waitForElementPresent(
//                By.xpath("//*[@content-desc='Java (programming language)']"),
//                "Cannot find OOP language by 'Java'",
//                5
//        );

        swipeUp(2000);
        swipeUp(2000);
        swipeUp(2000);
        swipeUp(2000);
        swipeUp(2000);

    }

    @Test
    public void testSwipeArticleSecond() {

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
                "Appium",
                "Cannot find search input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
                "Cannot find Appium in search",
                5
        );

//        waitForElementPresent(
//                By.xpath("//*[@content-desc='Java (programming language)']"),
//                "Cannot find OOP language by 'Java'",
//                5
//        );
        swipeUpToFindElement(
                By.xpath("//*[@text='View article in browser']"),
                "Cannot find the end of the article",
                20);


    }

    @Test
    public void saveFirstArticleToMyList() {

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

    }

    @Test
    public void testAmountOfNotEmptySearch() {

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
                "Linkin Park discography",
                "Cannot find search input",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@text='Linkin Park discography']"),
                "Cannot find anything by the request   ",
                15
        );

        int amount_of_search_results = getAmountOfElements(
                By.xpath("//*[@text='Linkin Park discography']")
        );

        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );

    }

    @Test
    public void testAmountOfEmptySearch() {

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


        String search_line = "bdrgergbewv";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                search_line,
                "Cannot find search input",
                5
        );

        String search_result = "//*[@text='Linkin Park discography']";
        String empty_result_label = "//*[@text='No results']";

        waitForElementPresent(
                By.xpath(empty_result_label),
                "Cannot find empty result label by the request" + search_line,
                15
        );

        assetElementNotPresent(
                By.xpath(search_result),
                "We found some results by request " + search_line
        );
    }

    @Test
    public void testChangeScreenOrientationOnSearchResults() {

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


        String search_line = "Java";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                search_line,
                "Cannot find search input",
                5
        );

        waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by " + search_line,
                5
        );

        String title_before_rotation = waitForElementAndGetAttribute(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "text",
                "Cannot find title of article",
                15
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = waitForElementAndGetAttribute(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "text",
                "Cannot find title of article",
                15
        );

        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_rotation
        );

        driver.rotate(ScreenOrientation.PORTRAIT);

        String title_after_second_rotation = waitForElementAndGetAttribute(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "text",
                "Cannot find title of article",
                15
        );

        Assert.assertEquals(
                "Article title have been changed after screen rotation",
                title_before_rotation,
                title_after_second_rotation
        );
    }

    @Test
    public void testCheckSearchArticleInBackground() {

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


        String search_line = "Java";
        waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                search_line,
                "Cannot find search input",
                5
        );

        waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by " + search_line,
                5
        );

        driver.runAppInBackground(Duration.ofSeconds(2));

        waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find article after returning backgroynd",
                5
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


}

