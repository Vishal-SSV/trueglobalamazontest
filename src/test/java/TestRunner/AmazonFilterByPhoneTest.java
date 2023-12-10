package TestRunner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageobjects.FilterPage;
import pageobjects.HomePage;
import utilities.ConfigFileReader;

public class AmazonFilterByPhoneTest extends BaseClass {
	
	public WebDriver driver;
	ConfigFileReader conf=new ConfigFileReader();
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver=intilizeBrowserAndOpenApplication(conf.getBrowserName());
		launchAmazonURL(conf.getApplicationUrl());
	}
	@Test(priority = 1)
	public void searchPhoneByFilter() throws Exception {
		// Search for "phone".
		HomePage hpa = new HomePage(driver);
		FilterPage fpa=new FilterPage(driver);
		hpa.searchPhone();
		hpa.clickOnSearchIcon();
		fpa.getFilterPhoneValue(conf.getBrandName());
		fpa.getLowPrice(conf.getLowPrice());
		fpa.getHighPrice(conf.getHighPrice());
		fpa.clickOnGo();
		fpa.getFilterPhoneValue(conf.getOsVersion());
				
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
