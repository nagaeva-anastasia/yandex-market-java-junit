package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSeleniumTest {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	protected void init(String url, String driverName)
	{								
		driver = initDriver(driverName);
		driver.get(url);
	}
	
	private WebDriver initDriver(String driverName)
	{			
		WebDriver d = null;
		
		switch (driverName)
		{
			case "Firefox":
			case "FF":
				d = new FirefoxDriver();
				break;
				
			case "InternerExplorer":
			case "IE":
				System.setProperty("webdriver.ie.driver",  System.getenv("ProgramFiles") + "/Internet Explorer/IEDriverServer.exe");
				
				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();

				ieCapabilities.setCapability("nativeEvents", false);    
				ieCapabilities.setCapability("unexpectedAlertBehaviour", "accept");
				ieCapabilities.setCapability("ignoreProtectedModeSettings", true);
				ieCapabilities.setCapability("disable-popup-blocking", true);
				ieCapabilities.setCapability("enablePersistentHover", true);
				
				d = new InternetExplorerDriver(ieCapabilities);
				
				break;
				
			case "ChromeDriver":
			default:
				System.setProperty("webdriver.chrome.driver",  System.getenv("ProgramFiles") + "/Google/Chrome/Application/chromedriver.exe");
				d = new ChromeDriver();
				break;
		}
		
		//driver.manage().window().maximize();
		
		return d;
	}
	
	protected void close()
	{		
		driver.close();
	}
}
