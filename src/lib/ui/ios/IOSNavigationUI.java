package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUi;

public class IOSNavigationUI extends NavigationUi {

    public IOSNavigationUI(AppiumDriver driver) {
        super(driver);
    }
// соответсвенно надо корректные локаторы для ios
    static {
        MY_LISTS_LINK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
        BUTTON_BACK = "xpath://android.widget.FrameLayout[@content-desc='My lists']";
    }
}
