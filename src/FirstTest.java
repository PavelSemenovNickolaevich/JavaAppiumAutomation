import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Test;

public class FirstTest extends CoreTestCase {
    private static final String
            BUTTON_SKIP = "xpath://*[contains(@text,'SKIP')]",
            SEARCH_INPUT = "//*[contains(@text,'Search Wikipedia')]",
            INPUT_WORDS = "xpath://*[contains(@text,'SKIP')]",
            ARTICLE = "xpath://*[@text='View article in browser']",
            FIND_WORD = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title'][@text='Appium']";


    private MainPageObject MainPageObject;

    protected void setUp() throws Exception {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }


    @Test
    public void testSwipeArticleSecond() {

        MainPageObject.waitForElementAndClick(
                BUTTON_SKIP,
                "Cannot find SKIP element",
                1
        );

        MainPageObject.waitForElementAndClick(
                SEARCH_INPUT,
                "Cannot find search input",
                5
        );


        MainPageObject.waitForElementAndSendKeys(
                INPUT_WORDS,
                "Appium",
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementAndClick(
                FIND_WORD,
                "Cannot find Appium in search",
                5
        );

//        waitForElementPresent(
//                By.xpath("//*[@content-desc='Java (programming language)']"),
//                "Cannot find OOP language by 'Java'",
//                5
//        );
        MainPageObject.swipeUpToFindElement(
                ARTICLE,
                "Cannot find the end of the article",
                20);


    }


}

