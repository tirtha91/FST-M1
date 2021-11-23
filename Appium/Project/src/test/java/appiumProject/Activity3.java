package appiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {
    WebDriverWait wait;
    AppiumDriver<MobileElement> driver;

    @BeforeTest
    public void driverSetup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 29");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void addNoteWithReminder() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("New text note")));
        driver.findElementByAccessibilityId("New text note").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/editable_title")));
        driver.findElementById("com.google.android.keep:id/editable_title").sendKeys("Sample Note with Reminder");

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/edit_note_text")));
        driver.findElementById("com.google.android.keep:id/edit_note_text").sendKeys("This note with Reminder is related to  FST Project ");
        driver.findElementByAccessibilityId("Reminder").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/menu_text")));
        driver.findElementByXPath("//android.widget.TextView[contains(@text,'Pick a date & time')]").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/time_spinner")));
        driver.findElementById("com.google.android.keep:id/time_spinner").click();

        Thread.sleep(3000);

        Boolean enableCheck = driver.findElementById("com.google.android.keep:id/reminder_time_night").isEnabled();
        System.out.println("Is Night menu item enabled: " + enableCheck);

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("com.google.android.keep:id/reminder_time_night")));
        driver.findElementById("com.google.android.keep:id/reminder_time_night").click();

        driver.findElementById("com.google.android.keep:id/save").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Open navigation drawer")));
        driver.findElementByAccessibilityId("Open navigation drawer").click();

        String noteTitle = driver.findElementById("index_note_title").getText();
        Assert.assertEquals(noteTitle, "Sample Note with Reminder");
        Assert.assertTrue(driver.findElementById("reminder_chip_text").isDisplayed());
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}