package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUi;

public class AndroidNavigationUI extends NavigationUi {
    public AndroidNavigationUI(AppiumDriver driver) {
        super(driver);
    }

    static {
        MY_LISTS_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
        BUTTON_BACK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    }
}
