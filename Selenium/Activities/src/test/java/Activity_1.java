import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class Activity_1 {

    public static void main(String[] args) {
        File FirefoxDriver = new File(System.getProperty("user.dir") + "//WebDrivers//geckodriver.exe");
        System.setProperty("webdriver.gecko.driver",FirefoxDriver.getAbsolutePath());
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://www.training-support.net");

        //Close the browser
        driver.close();
    }

}
