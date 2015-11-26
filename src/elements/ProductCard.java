package elements;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseSeleniumPage;

public class ProductCard extends BaseSeleniumPage {
    
	private WebElement parent;
	
    public ProductCard(WebDriver driver, WebElement p) { 
    	super(driver);    	
    	parent = p;
    }    
}
