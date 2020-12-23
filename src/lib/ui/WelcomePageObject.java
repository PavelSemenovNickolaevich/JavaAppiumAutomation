package lib.ui;

import io.appium.java_client.AppiumDriver;

public class WelcomePageObject extends MainPageObject {

    private static final String
            STEP_LEARN_MORE_LINK = "id:Learn more about Wikipedia",
            BUTTON_NEXT = "id:Next",
            NEXT_ONE = "id:New ways to explore",
            NEXT_TWO = "id:dd or edit preferred languages",
            NEXT_THREE = "id:Learn more about data collected",
            NEXT_FOURTH = "id:Get started",
            SKIP = "id:Skip";

    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void waitForLearnMoreLink() {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "Cannot find ...", 10);
    }

    public void clickNextButton() {
        this.waitForElementPresent(BUTTON_NEXT, "Cannot find ...", 10);
    }

    public void waitForNewWayToExploreText() {
        this.waitForElementPresent(NEXT_ONE, "Cannot find ...", 10);
    }

    public void waitForAddEditPreferredLangText() {
        this.waitForElementPresent(NEXT_TWO, "Cannot find ...", 10);
    }

    public void waitForLearnMoreAboutDataCollectedText() {
        this.waitForElementPresent(NEXT_THREE, "Cannot find ...", 10);
    }

    public void clickGetStartedButton() {
        this.waitForElementPresent(NEXT_FOURTH, "Cannot find ...", 10);
    }


    public void clickSkip() {
        this.waitForElementAndClick(SKIP, "Cannot find click and skip button", 5);
    }
}
