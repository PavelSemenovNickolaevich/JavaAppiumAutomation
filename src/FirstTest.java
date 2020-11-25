import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSearch() throws InterruptedException {


        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP element",
                1
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndSendKeys(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Java",
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by 'Java'",
                15);
    }

    @Test
    public void testCancelSearch() throws InterruptedException {

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP element",
                1
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                By.className("android.widget.FrameLayout"),
                "Java",
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndClear(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot search field",
                5
        );


        MainPageObject.waitForElementAndClick(
                By.className("android.widget.ImageButton"),
                "Cannot find search input",
                5
        );


        MainPageObject.waitForElementNotPresent(
                By.className("android.widget.ImageButton"),
                "Back is still on the page",
                5
        );

    }

    @Test
    public void testCompareArticleTitle() {

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP element",
                1
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                By.className("android.widget.FrameLayout"),
                "Java",
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by 'Java'",
                5
        );

        WebElement title_element = MainPageObject.waitForElementPresent(
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

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP element",
                1
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by 'Java'",
                5
        );

//        waitForElementPresent(
//                By.xpath("//*[@content-desc='Java (programming language)']"),
//                "Cannot find OOP language by 'Java'",
//                5
//        );

        MainPageObject.swipeUp(2000);
        MainPageObject.swipeUp(2000);
        MainPageObject.swipeUp(2000);
        MainPageObject.swipeUp(2000);
        MainPageObject.swipeUp(2000);

    }

    @Test
    public void testSwipeArticleSecond() {

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP element",
                1
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Appium",
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']"),
                "Cannot find Appium in search",
                5
        );

//        waitForElementPresent(
//                By.xpath("//*[@content-desc='Java (programming language)']"),
//                "Cannot find OOP language by 'Java'",
//                5
//        );
        MainPageObject.swipeUpToFindElement(
                By.xpath("//*[@text='View article in browser']"),
                "Cannot find the end of the article",
                20);


    }

    @Test
    public void testSaveFirstArticleToMyList() {

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP element",
                1
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Java",
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by 'Java'",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by 'Java'",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/article_menu_bookmark"),
                "Cannot find button to open article options",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/snackbar_action"),
                "Cannot find button ADD TO LIST",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.id("org.wikipedia:id/onboarding_button"),
                "Cannot find 'Got it' tip overlay ",
                5
        );
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/text_input"),
                "Learning programming",
                "Cannot put text articles folder input",
                5
        );
        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='OK']"),
                "Cannot press pk button",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"),
                "Cannot close article, cannot find arrow link",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.ImageButton[@index='0']"),
                "Cannot close article, cannot find arrow link",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//android.widget.FrameLayout[@content-desc='My lists']"),
                "Cannot find icon",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Learning programming']"),
                "Cannot find 'Learning programming'",
                5
        );

        MainPageObject.swipeElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find saved article"
        );

        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot delete saved article ",
                5
        );

    }

    @Test
    public void testAmountOfNotEmptySearch() {

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP element",
                1
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                "Linkin Park discography",
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Linkin Park discography']"),
                "Cannot find anything by the request   ",
                15
        );

        int amount_of_search_results = MainPageObject.getAmountOfElements(
                By.xpath("//*[@text='Linkin Park discography']")
        );

        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results > 0
        );

    }

    @Test
    public void testAmountOfEmptySearch() {

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP element",
                1
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );


        String search_line = "bdrgergbewv";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                search_line,
                "Cannot find search input",
                5
        );

        String search_result = "//*[@text='Linkin Park discography']";
        String empty_result_label = "//*[@text='No results']";

        MainPageObject.waitForElementPresent(
                By.xpath(empty_result_label),
                "Cannot find empty result label by the request" + search_line,
                15
        );

        MainPageObject.assetElementNotPresent(
                By.xpath(search_result),
                "We found some results by request " + search_line
        );
    }

    @Test
    public void testChangeScreenOrientationOnSearchResults() {

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP element",
                1
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );


        String search_line = "Java";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                search_line,
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by " + search_line,
                5
        );

        String title_before_rotation = MainPageObject.waitForElementAndGetAttribute(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "text",
                "Cannot find title of article",
                15
        );

        driver.rotate(ScreenOrientation.LANDSCAPE);

        String title_after_rotation = MainPageObject.waitForElementAndGetAttribute(
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

        String title_after_second_rotation = MainPageObject.waitForElementAndGetAttribute(
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

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'SKIP')]"),
                "Cannot find SKIP element",
                1
        );

        MainPageObject.waitForElementAndClick(
                By.xpath("//*[contains(@text,'Search Wikipedia')]"),
                "Cannot find search input",
                5
        );


        String search_line = "Java";
        MainPageObject.waitForElementAndSendKeys(
                By.id("org.wikipedia:id/search_src_text"),
                search_line,
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find OOP language by " + search_line,
                5
        );

        driver.runAppInBackground(Duration.ofSeconds(2));

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find article after returning backgroynd",
                5
        );

    }

}

