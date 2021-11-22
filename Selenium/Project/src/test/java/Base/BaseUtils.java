package Base;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseUtils {
	
	public static WebDriver driver;
	public ExtentReports extent;
	public static ExtentTest features;
	public static ExtentTest scenarioDef;
	public static String reportLoc = System.getProperty("user.dir") + "//extentReports//";
   
}
