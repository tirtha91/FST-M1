package appiumProject;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.TouchAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity5 {
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException, IOException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 API 29");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);
        // Initialize driver
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver,20);

        driver.get("https://www.training-support.net/selenium");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test (priority=1)
    public void validCredentials() throws InterruptedException {

        TouchAction action = new TouchAction(driver);
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[2][contains(@text,'Get Started!')]")));
        driver.findElementByXPath("//android.widget.Button[2][contains(@text,'Get Started!')]").click();

//        driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().scrollable(true))" +
//                        ".scrollIntoView(new UiSelector().textContains(\"Login Form\"))"));
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[contains(@text,'Login Form')]")));
        driver.findElementByXPath("//android.view.View[contains(@text,'Login Form')]").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[1][contains(@resource-id,'username')]")));
        driver.findElementByXPath("//android.widget.EditText[1][contains(@resource-id,'username')]").sendKeys("admin");
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[2][contains(@resource-id,'password')]")));
        driver.findElementByXPath("//android.widget.EditText[2][contains(@resource-id,'password')]").sendKeys("password");
        driver.findElementByXPath("//android.widget.Button[contains(@text,'Log in')]").click();
        Thread.sleep(5000);
        String loginMessage = driver.findElementByXPath("//android.view.View[contains(@text,'Welcome Back, admin')]").getText();

        Assert.assertEquals(loginMessage, "Welcome Back, admin");
    }

    @Test (priority=2)
    public void invalidCredentials() throws InterruptedException {

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.Button[2][contains(@text,'Get Started!')]")));
        Thread.sleep(5000);
        driver.findElementByXPath("//android.widget.Button[2][contains(@text,'Get Started!')]").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.view.View[contains(@text,'Login Form')]")));
        driver.findElementByXPath("//android.view.View[contains(@text,'Login Form')]").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[1][contains(@resource-id,'username')]")));
        driver.findElementByXPath("//android.widget.EditText[1][contains(@resource-id,'username')]").sendKeys("admin");
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[2][contains(@resource-id,'password')]")));
        driver.findElementByXPath("//android.widget.EditText[2][contains(@resource-id,'password')]").sendKeys("wrong");
        driver.findElementByXPath("//android.widget.Button[contains(@text,'Log in')]").click();
        Thread.sleep(5000);
        String expText = driver.findElementByXPath("//android.view.View[contains(@text,'Invalid Credentials')]").getText();

        Assert.assertEquals(expText, "Invalid Credentials");
    }

    @AfterClass
    public void afterMethod()
    {
        driver.quit();
    }

}