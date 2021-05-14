package stepDefinition;

import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseClass{
	
	@Before
	public void initWebDriver()
	{
		// This is where the configuration for different drivers could be placed.
		System.setProperty("webdriver.gecko.driver","C:\\Program Files (x86)\\Selenium-java-3.141.59\\drivers\\geckodriver.exe");
		webDriver = new FirefoxDriver();
	}

	@After
	public void closeDriver()
	{
		webDriver.quit();
	}

}
