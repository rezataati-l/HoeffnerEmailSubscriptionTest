package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProtonMailInbox {
	
	private WebDriver webDriver;

	public ProtonMailInbox(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void click_first_mail() throws InterruptedException {
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // waiting for the registration email 
		WebElement emailsListContainer = webDriver.findElement(By.cssSelector("section[class='conversation-wrapper']"));
		List<WebElement> emailsList = emailsListContainer.findElements(By.xpath(".//*"));
		emailsList.get(0).click();
	}
	
	public boolean is_complete_registration_button_displayed() {
		return webDriver.findElement(By.cssSelector("a[title='Jetzt Anmeldung abschlieﬂen']")) != null;
	}

}
