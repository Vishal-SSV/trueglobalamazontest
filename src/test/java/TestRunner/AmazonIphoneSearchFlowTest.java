package TestRunner;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pageobjects.FilterPage;
import pageobjects.HomePage;
import pageobjects.ProductDetailPage;
import utilities.ConfigFileReader;

public class AmazonIphoneSearchFlowTest extends BaseClass {
	
	public WebDriver driver;
	ConfigFileReader conf=new ConfigFileReader();
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver=intilizeBrowserAndOpenApplication(conf.getBrowserName());
		launchAmazonURL(conf.getApplicationUrl());
	}
	@Test(priority = 1)
	public void searchAndAddToCart() throws Exception {
		// Search for "iphone".
		HomePage hpa = new HomePage(driver);
		hpa.searchIphone();
		List<WebElement> iphoneList = hpa.getListOfIphone();
		for (int i = 0; i < iphoneList.size(); i++) {
			System.out.println(iphoneList.get(i).getText());
			if (iphoneList.get(i).getText().contains(conf.getPhoneType())) {
				iphoneList.get(i).click();
				break;
			}
		}
		// Go to the product details page

		String parentWindow = driver.getWindowHandle();
		ProductDetailPage pdp = new ProductDetailPage(driver);
		pdp.productSelectFromResult();
		driver.manage().timeouts().pageLoadTimeout(dur);

		Set<String> allWindows = driver.getWindowHandles();

		Iterator<String> it = allWindows.iterator();
		String parentWindowID = it.next();
		String childWindowID = it.next();
		driver.switchTo().window(childWindowID);
		// Get the price and store it in 'selectedPhonePrice' variable
		pdp.productPrice();

		// Add to cart
		pdp.clickOnAddCart();

	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
