package yandexMarket;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseSeleniumPage;

public class MainPage extends BaseSeleniumPage {
    @FindBy(xpath = "//li[@data-department='Электроника']/a")
    private WebElement electronicLink;
    
    @FindBy(xpath = "//a[contains(@class, 'topmenu__subite') and text() = 'Мобильные телефоны']")
    private WebElement mobilePhone;
    
    @FindBy(xpath = "//div[@class='header2__logo']/a/img")
    private WebElement logo;
    
    public MainPage(WebDriver driver) { 
    	super(driver);    	
    }
    
    public boolean checkLogo()
    {
    	long width;
    	long height;
    	
    	try
    	{
    		width = (long) ((JavascriptExecutor) driver).executeScript("return arguments[0].width", logo);
        	height = (long) ((JavascriptExecutor) driver).executeScript("return arguments[0].height", logo);	    		
    	}
    	catch (Exception ex)
    	{
    		return false;
    	}    	
    	
    	return logo.isDisplayed() && 
    			width > 15 && 
    			height > 15;
    }
    
    public MobilePhonePage NavigateToMobilePhones()
    {
    	electronicLink.click();		
		mobilePhone.click();
		
		return PageFactory.initElements(driver, MobilePhonePage.class);
    }
}
