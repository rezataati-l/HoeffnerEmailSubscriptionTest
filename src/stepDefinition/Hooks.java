package stepDefinition;

import java.util.ArrayList;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.ProtonMailInbox;
import pages.UnsubscribePage;

public class Hooks extends BaseClass{
	
	@Before
	public void initWebDriver()
	{
		// This is where the configuration for different drivers could be placed.
		System.setProperty("webdriver.gecko.driver","C:\\Program Files (x86)\\Selenium-java-3.141.59\\drivers\\geckodriver.exe");
		webDriver = new FirefoxDriver();
		webDriver.manage().window().maximize();
	}

	@After
	public void teardown()
	{
		try {
			if (doUnregisterEmailSubscriptionInTearDown) {
				unregisterSubscription();
			}
			cleanupInbox();
		}
		catch (Exception e) {
			// Nothing is required here.
		}
		
		webDriver.quit();
	}
	
	private void unregisterSubscription() throws InterruptedException {
		Thread.sleep(60000); // Waiting for completion of previous registration.

		ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs.get(0));
		if (webDriver.getTitle().contains("Inbox | linkmail001@protonmail.com | ProtonMail")) {
			new ProtonMailInbox(webDriver).issue_unsubscription();
			tabs = new ArrayList<String> (webDriver.getWindowHandles());
			webDriver.switchTo().window(tabs.get(1));
			new UnsubscribePage(webDriver).unsubscribe();
		}
	}
	
	private void cleanupInbox() {
		ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs.get(0));
		if (webDriver.getTitle().contains("Inbox | linkmail001@protonmail.com | ProtonMail")) {
			new ProtonMailInbox(webDriver).cleanup_Inbox_folder();			
		}
	}

}
