package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject {

    //В значение переменных ставится локакторы ios
    static {
        SEARCH_INIT_ELEMENT = "xpath://*[contains(@text,'Search Wikipedia')]";
        SEARCH_INPUT = "xpath://*[contains(@text,'Search Wikipedia')]";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@text='{SUBSTRING}']";
        SKIP_FIRST_PAGE = "xpath://*[contains(@text,'SKIP')]";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[@text='No results']";
        SEARCH_RESULT_ELEMENT = "xpath://*[@text='Linkin Park discography']";
        SEARCH_RESULT_ELEMENTS = "id:org.wikipedia:id/page_list_item_title";
        SEARCH_RESULT_WITH_TITLE_AND_DESCRIPTION = "xpath://android.view.ViewGroup/*[@text='{SUBSTRING_TITLE}']/../*[@text='{SUBSTRING_DESCRIPTION}']";
    }

    public IOSSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
