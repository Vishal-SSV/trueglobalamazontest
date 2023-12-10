package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePage extends BaseClass {
	
	public WebDriver driver;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(xpath="//div[@class='left-pane-results-container']/descendant::div[@aria-label='iphone']")
	List<WebElement> ls;
	
	@FindBy(xpath ="//input[@id='nav-search-submit-button']")
	WebElement searchIcon;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void searchIphone() {
		searchBox.sendKeys("iphone");
	}
	
	public void searchPhone() {
		searchBox.sendKeys("phone");
	}
	

	public void clickOnSearchIcon() {
		searchIcon.click();
	}
	
	
	public List<WebElement> getListOfIphone()
	{
		return ls;
	}

}
