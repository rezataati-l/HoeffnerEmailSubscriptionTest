package pages;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProtonMailInbox {
	
	private WebDriver webDriver;

	public ProtonMailInbox(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void click_first_mail() {
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 30);
		WebElement emailsListContainer = 
				webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("section[class='conversation-wrapper']")));
		
		for (int i = 0; i < 30; i++) { // Refreshing the inbox until registration email is received.
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// Nothing is required here.
			}
			List<WebElement> emailsList = emailsListContainer.findElements(By.xpath(".//*"));
			if (emailsList.size() > 0) {
				try {
					emailsList.get(0).findElement(By.xpath("//span[.='Bitte best‰tigen Sie Ihre Anmeldung!']"));
					emailsList.get(0).click();
					break;
				}
				catch (NoSuchElementException e) {
					// Nothing is required here.
				}
			}
			webDriver.findElement(By.xpath("//a[@class='navigationItem-item ptDnd-dropzone-container' and @data-label='Inbox']")).click();
		}
	}
	
	public boolean is_complete_registration_button_displayed() {
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15);
		WebElement completeRegistrationLink = 
				webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[title='Jetzt Anmeldung abschlieﬂen']")));
		
		return completeRegistrationLink != null;
	}
	
	public void click_complete_registration_button() {
		webDriver.findElement(By.cssSelector("a[title='Jetzt Anmeldung abschlieﬂen']")).click();
	}
	
	public void cleanup_Inbox_folder() {
		webDriver.findElement(By.id("selectAll")).click();
		webDriver.findElement(By.cssSelector("button[class='pm_buttons-child fa fa-trash-o toolbar-btn-trash moveElement-btn-trash']")).click();
	}
	
	public void issue_unsubscription() {
		webDriver.findElement(By.xpath("//a[contains(@href, 'https://email.hoeffner.de/u/un.php')]")).click();
	}

}
