package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class IOSArticlePageObject extends ArticlePageObject {

    //локаторы для ios ( здесь некоррректные )

     static {
        TITLE = "xpath://*[@text='Java (programming language)']";
        FOOTER_ELEMENT = "xpath://*[@text='View page in browser']";
        OPTIONS_BUTTON = "id:org.wikipedia:id/article_menu_bookmark";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:org.wikipedia:id/snackbar_action";
        ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button";
        MY_LIST_INPUT = "id:org.wikipedia:id/text_input";
        MY_LIST_OK_BUTTON = "xpath://*[@text='OK']";
        CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";
        CLOSE_ARTICLE_BUTTON_ONE = "xpath://android.widget.ImageButton[@index='0']";
        ARTICLE_TWO = "xpath://*[@text='High-level programming language']";
        ARTICLE_THREE = "xpath://*[@text='High-level programming language']";
        TITLE_LIST = "org.wikipedia:id/item_title";
    }

    public IOSArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
