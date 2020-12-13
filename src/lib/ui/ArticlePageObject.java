package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
            TITLE = "xpath://*[@text='Java (programming language)']",
            FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
            OPTIONS_BUTTON = "id:org.wikipedia:id/article_menu_bookmark",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:org.wikipedia:id/snackbar_action",
            ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
            MY_LIST_INPUT = "id:org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
            CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']",
            CLOSE_ARTICLE_BUTTON_ONE = "xpath://android.widget.ImageButton[@index='0']",
            ARTICLE_TWO = "xpath://*[@text='High-level programming language']",
            ARTICLE_THREE = "xpath://*[@text='High-level programming language']",
            TITLE_LIST = "org.wikipedia:id/item_title";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter() {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of article",
                100
        );
    }

    public void addArticleToMyList(String name_of_folder) {

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button ADD TO LIST",
                5
        );


        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay ",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_INPUT,
                name_of_folder,
                "Cannot put text articles folder input",
                5
        );
        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press pk button",
                5
        );
    }

    public void addSecondArticleToMyList() {

        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button ADD TO LIST",
                5
        );

        this.waitForElementAndClick(
                TITLE_LIST,
                "Cannot find folder title",
                5
        );
    }


    public void closeArticle() {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find arrow link",
                5
        );
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON_ONE,
                "Cannot close article, cannot find arrow link",
                5
        );
    }

    public void closeArticleOneClick() {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find arrow link",
                5
        );
    }

    public void assertArticleExists() {
        this.waitForElementAndClick(
                ARTICLE_TWO,
                "Cannot find JS High-level programming language'",
                5
        );

        this.waitForElementPresent(
                ARTICLE_THREE,
                "Cannot find High-level programming language title",
                5
        );
    }

    public void assertTitlePresentWithoutTimeOut() {
        this.assertElementPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Cannot find element - title"
        );
    }


}
