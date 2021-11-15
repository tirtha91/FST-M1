package testrunner;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.gherkin.model.Feature;

import static Base.BaseUtils.features;

import java.io.IOException;

import Base.ExtentReportUtils;

public class NGTestListener implements ITestListener {

	ExtentReportUtils extentReportUtils = new ExtentReportUtils();
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test start");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test failure");
//		try{
//			extentReportUtils.ExtentReportScreenshot();
//		}catch (IOException e){
//			e.printStackTrace();
//		}
	}
		

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test skip");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("On Test failed percentage");
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On start");
		extentReportUtils.ExtentReport();
//		adding feature -> To Do - hard coding the feature name which needs to be removed
		features = extentReportUtils.extent.createTest(Feature.class, "LoginFeature");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finish");
		extentReportUtils.FlushReport();
	}

}
