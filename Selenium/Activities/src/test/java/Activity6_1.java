import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Activity6_1 {

    public static void main(String[] args) {
        File FirefoxDriver = new File(System.getProperty("user.dir") + "//WebDrivers//geckodriver.exe");
        System.setProperty("webdriver.gecko.driver",FirefoxDriver.getAbsolutePath());
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //Open browser
        driver.get("https://training-support.net/selenium/dynamic-controls");

        //Find checkbox and toggle button
        WebElement checkbox = driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
        WebElement toggleCheckboxButton = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));

        //Click the toggle button
        toggleCheckboxButton.click();

        //Wait for checkbox to disappear
        wait.until(ExpectedConditions.invisibilityOf(checkbox));

        //Click toggle button again
        toggleCheckboxButton.click();

        //Wait for checkbox to appear
        wait.until(ExpectedConditions.visibilityOf(checkbox));
        checkbox.click();

        //Close browser
        driver.close();
    }

}