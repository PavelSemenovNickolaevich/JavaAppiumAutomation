package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class NavigationUi extends MainPageObject {

    private static final String
            MY_LISTS_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']",
            BUTTON_BACK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";

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
