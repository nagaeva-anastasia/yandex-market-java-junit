package yandexMarket;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseSeleniumPage;

public class MobilePhonePage extends BaseSeleniumPage {
	@FindBy(xpath = "//h1[@class='b-page-title__title']")
	private WebElement header;
	
    @FindBy(xpath = "//input[@name='2140131888']")
    private WebElement priceFrom;
    
    @FindBy(xpath = "//input[@name='2140131887']")
    private WebElement priceTo;
    
    @FindBy(xpath = "//select[@name='2142557977']")
    private WebElement platform;
    
    @FindBy(xpath = "//select[@name='2142542726']")
    private WebElement type;
    
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;
        
    public MobilePhonePage(WebDriver driver) { 
    	super(driver);
    }
    
    public boolean checkHeader()
    {
    	return header.isDisplayed();
    }
    
    public SearchResultPage FillFiltersAndSubmit(String pFrom, String pTo, String p, String t)
    {
    	priceFrom.sendKeys(pFrom);
    	priceTo.sendKeys(pTo);
    	new Select(platform).selectByVisibleText(p);
    	new Select(type).selectByVisibleText(t);
    	
    	submitButton.click();
    	
    	return PageFactory.initElements(driver, SearchResultPage.class);    	
    }
       
}
