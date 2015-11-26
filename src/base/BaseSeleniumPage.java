package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseSeleniumPage {
	protected WebDriver driver;
	
	public BaseSeleniumPage(WebDriver d)
	{
		driver = d;			
	}
}
