package TestRunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import utilities.ConfigFileReader;

public class AmazonRegisterUsersTest extends BaseClass {
	
	public WebDriver driver;
	ConfigFileReader conf=new ConfigFileReader();
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver=intilizeBrowserAndOpenApplication(conf.getBrowserName());
		launchAmazonURL(conf.getApplicationUrl());
	}

	/*
	 * @Test(priority = 1) public void registerUsers() throws Exception {
	 * 
	 * }
	 */
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
