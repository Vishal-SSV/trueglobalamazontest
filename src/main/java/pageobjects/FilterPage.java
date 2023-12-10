package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseClass;

public class FilterPage extends BaseClass {
	
	public WebDriver driver;
	String value;
	
	@FindBy(xpath="//div[@class='a-section a-spacing-double-large']/descendant::span[contains(text(),'\"+value+\"')]")
	WebElement filterValue;
	
	@FindBy(id="low-price")
	WebElement lowPrice;
	
	@FindBy(id="high-price")
	WebElement highPrice;
	
	@FindBy(xpath="//input[@class='a-button-input']")
	WebElement goBtn;
	
//	@FindBy(xpath="//div[@class='a-section a-spacing-double-large']/descendant::span[contains(text(),'realme')]")
//	WebElement brandName;
//
//	@FindBy(xpath="//span[contains(text(),'Android 11.0')]")
//	WebElement opertingSystem;
//	
//	@FindBy(xpath="//span[contains(text(),'32 GB')]")
//	WebElement memoryStorage;
//	
//	@FindBy(xpath="//span[contains(text(),'3,000 to 3,999 mAh')]")
//	WebElement batteryCapacity;
//	
//	@FindBy(xpath="//span[@class='a-size-base a-color-base a-text-bold'][normalize-space()='4G']")
//	WebElement celluarTech;
//	
//	@FindBy(xpath="//span[contains(text(),'5.5 in & above')]")
//	WebElement screenSize;
//	
//	@FindBy(xpath="//span[contains(text(),'2 to 3.9 GB')]")
//	WebElement ramSize;
//	
	@FindBy(xpath="//span[@class='a-size-base-plus a-color-base a-text-normal']")
	WebElement phonetitle;

	
	public FilterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void getFilterPhoneValue(String value)
	{
		WebDriverWait wait=new WebDriverWait(driver, dur);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='a-section a-spacing-double-large']/descendant::span[contains(text(),'"+value+"')]")));
		driver.findElement(By.xpath("//div[@class='a-section a-spacing-double-large']/descendant::span[contains(text(),'"+value+"')]")).click();
	}
	
	public void getLowPrice(String lowprice)
	{
		lowPrice.sendKeys(lowprice);
	}
	public void getHighPrice(String maxprice)
	{
		highPrice.sendKeys(maxprice);
	}
	public void clickOnGo()
	{
		goBtn.click();
	}
}


