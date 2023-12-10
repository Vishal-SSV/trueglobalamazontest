package utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter extends UtilitiesClass{
	
	public static ExtentReports genrateExtentReports() {
		
		ExtentReports extentReport=new ExtentReports();
		File extentReportFile=new File(System.getProperty("user.dir")+"\\ExtentReports\\extentReport"+genrateTimeStamp()+".html");
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Amazon Test Result");
		sparkReporter.config().setDocumentTitle("Amazon Automation Result");
		sparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Oprating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReport.setSystemInfo("User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Tested By", "Vishal Parsewar");
		extentReport.setSystemInfo("Reviewed By", "Vivek T");
		
		return extentReport;
	}

}
