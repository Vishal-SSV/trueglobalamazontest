package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utilities.ExtentReporter;

public class ListnerClass implements ITestListener{
	
	public ExtentReports extentReport;
	public ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {
		extentReport =ExtentReporter.genrateExtentReports();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
		String testname=result.getName();
		extentTest= extentReport.createTest(testname);
		extentTest.log(Status.INFO, testname+"Execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testname=result.getName();
		extentTest.log(Status.PASS, testname+"Successfully Executed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname=result.getName();
		WebDriver driver=null;
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String destnationScreenShotPath=System.getProperty("user.dir")+"\\Screenshots\\"+testname+".png";
		try {
			FileHandler.copy(screenShotFile, new File(destnationScreenShotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(destnationScreenShotPath);
		
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.FAIL, testname+"Execution Failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testname=result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testname+"Execution Skipped");
	}	

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}


}
