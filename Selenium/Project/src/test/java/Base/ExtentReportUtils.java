package Base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportUtils extends BaseUtils {
		
	String fileName = reportLoc + "extentreport.html";
	
//	private BaseUtils base; 
//	
//	public ExtentReportUtils(BaseUtils base) {
//		this.base = base;
//	}
//	
//	public ExtentReportUtils() {
//		
//	}
	
	public void ExtentReport()
	{
		//First is to create Extent Reports object
		extent = new ExtentReports();
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Extent report for Selenium Cucumber");
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setReportName("Extent Report");
		
		extent.attachReporter(htmlReporter);
	}
	
	public void ExtentReportScreenshot() throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src.toPath(), new File(reportLoc + "screenshot.png").toPath());
		scenarioDef.fail("details").addScreenCaptureFromPath(reportLoc + "screenshot.png");
	}
	public void FlushReport()
	{
        extent.flush();
    }
	
//	1. Create ExtentReport object invocation within ExtentReportUtils
//	2. Create Features within test listeners
//	3. Create scenario within @Before tag in hooks
//	4. Create steps in the step definition
//	5. Call failure within listener's Onfailure
//	6. Call flush from listener


}
