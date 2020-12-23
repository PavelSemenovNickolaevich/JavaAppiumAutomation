package lib.ui;

import io.appium.java_client.AppiumDriver;

abstract public class NavigationUi extends MainPageObject {


    protected static String
            MY_LISTS_LINK,
            BUTTON_BACK;

    public NavigationUi(AppiumDriver driver) {
        super(driver);
    }

    public void ClickMyLists() {
        this.waitForElementAndClick(
                MY_LISTS_LINK,
                "Cannot find icon",
                5
        );
    }

    public void clickBackButton() {
        waitForElementAndClick(
                BUTTON_BACK,
                "Cannot close article, cannot find arrow link",
                5
        );
    }
}
