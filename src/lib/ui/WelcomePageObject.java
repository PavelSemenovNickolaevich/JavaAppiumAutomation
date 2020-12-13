package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject {

    private static final String
            STEP_LEARN_MORE_LINK = "Learn more about Wikipedia";

    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void waitForLearnMoreLink() {
        this.waitForElementPresent(By.id(STEP_LEARN_MORE_LINK), "Cannot find ...", 10);
    }

    public void clickNextButton() {
        this.waitForElementPresent(By.id("Next"), "Cannot find ...", 10);
    }

    public void waitForNewWayToExploreText() {
        this.waitForElementPresent(By.id("New ways to explore"), "Cannot find ...", 10);
    }

    public void waitForAddEditPreferredLangText() {
        this.waitForElementPresent(By.id("Add or edit preferred languages"), "Cannot find ...", 10);
    }

    public void waitForLearnMoreAboutDataCollectedText() {
        this.waitForElementPresent(By.id("Learn more about data collected"), "Cannot find ...", 10);
    }

    public void clickGetStartedButton() {
        this.waitForElementPresent(By.id("Get started"), "Cannot find ...", 10);
    }


}
