package pageobjects;

import java.time.Duration;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage {
	
	
	public WebDriver driver;
	
	public Duration dur=Duration.ofSeconds(20);
	
	@FindBy(xpath="//img[contains(@alt,'Sponsored Ad - Apple iPhone 13')]")
	WebElement productSelectFromResult;
	
	@FindBy(xpath="//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']/descendant::span[@class='a-price-whole']")
	WebElement productPrice;
	
	@FindBy(xpath="(//input[@id='add-to-cart-button'])[1]")		
	WebElement addCartButton;
	
	
	public ProductDetailPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void productSelectFromResult() {
		productSelectFromResult.click();
	}
	
	public void productPrice() {
		WebDriverWait wait=new WebDriverWait(driver,dur);
		wait.until(ExpectedConditions.visibilityOf(productPrice));
		String priceofProduct=productPrice.getText();
		System.out.println("Iphone Price is:"+priceofProduct);
	}
	
	public void clickOnAddCart() throws Exception {
		WebDriverWait wait=new WebDriverWait(driver, dur);
		wait.until(ExpectedConditions.elementToBeClickable((addCartButton)));
		addCartButton.click();
	}

}
