package InterviewProgram;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestJava {

	

		public void initializeDriver() {
			
			WebDriver driver;
			File chromedriver = new File(System.getProperty("user.dir") + "//WebDrivers//chromedriver.exe");
			System.setProperty("webdriver.chrome.driver",chromedriver.getAbsolutePath());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized","--disable-infobars");
			driver = new ChromeDriver(options);
			
			driver.get("http://www.google.com");
		}
//	num_rows = len (driver.find_elements_by_xpath("//*[@id='customers']/tbody/tr"))
//	num_cols = len (driver.find_elements_by_xpath("//*[@id='customers']/tbody/tr[2]/td"))


}
