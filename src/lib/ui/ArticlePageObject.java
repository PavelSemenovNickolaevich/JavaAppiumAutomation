package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON,
            CLOSE_ARTICLE_BUTTON_ONE,
            ARTICLE_TWO,
            ARTICLE_THREE,
            TITLE_LIST;

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);
    }

    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return title_element.getAttribute("text");
        } else {
            return title_element.getAttribute("name");
        }
    }

    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40
            );
        } else {
            this.swipeUpTitleElementAppear(
                    FOOTER_ELEMENT,
                    "Cannot fint the end of article",
                    40);
        }
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
                10
        );

        this.waitForElementAndClick(
                TITLE_LIST,
                "Cannot find folder title",
                10
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

    public void addArticlesTiMySaved() {
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 5 );
    }


}
