package pages;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	
	private WebDriver webDriver;

	public RegistrationPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public String get_page_title() {
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // waiting for page redirection
		ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
		webDriver.switchTo().window(tabs.get(1));
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
		webDriverWait.until(ExpectedConditions.titleContains("Anmeldung"));
		return webDriver.getTitle();
	}
	
	public boolean is_registration_acknowledgment_message_displayed() {
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
		WebElement registrationAcknowledgementMessage = 
				webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Vielen Dank für Ihre Anmeldung!']")));
		return registrationAcknowledgementMessage != null;
	}

}
