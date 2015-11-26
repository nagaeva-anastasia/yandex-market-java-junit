package seleniumTests;
import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.BaseSeleniumTest;
import config.*;
import yandexMarket.*;

@RunWith(Parameterized.class)
public class FilterPhoneByPricePlatformType extends BaseSeleniumTest {	    
	
	private ConfigStruct currentConfig;
	
    @Parameterized.Parameters
    public static Collection<ConfigStruct> getConfigStructure() {    	    
        return new TestConfig("src/config.xml").GetValues();    	
    }
    	
    public FilterPhoneByPricePlatformType(ConfigStruct config) {  
    	currentConfig = config;
        init("http://market.yandex.ru", currentConfig.browser);
    }
    		
	@Test	
	public void testMethod()
	{						
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		assertTrue(mainPage.checkLogo());
		
		MobilePhonePage mobilePhones = mainPage.NavigateToMobilePhones();
		assertTrue(mobilePhones.checkHeader());
		
		SearchResultPage searchPage =	
				mobilePhones.FillFiltersAndSubmit(currentConfig.priceFrom, 
								currentConfig.priceTo, 
								currentConfig.platform, 
								currentConfig.type);
		
		assertTrue(searchPage.getProductCards().size() > 0);
		assertTrue(searchPage.CheckPrices(currentConfig.priceFrom, currentConfig.priceTo));
		assertTrue(searchPage.CheckBoxes(currentConfig.type, currentConfig.platform));
		
		close();
	}	
} 
