package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	private WebDriver webDriver;
	private static final String lOGIN_PAGE_URL = "https://www.hoeffner.de/login"; 

	public LoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void open_page() {
		webDriver.get(lOGIN_PAGE_URL);
	}
	
	public String get_page_title() {
		return webDriver.getTitle();
	}
	
	public void close_cookie_popup_if_exists() {
		WebElement cookiePopup = webDriver.findElement(By.cssSelector(".consentForm__root"));
		if (cookiePopup!= null) {
			cookiePopup.findElement(By.cssSelector(".button")).click();
		}
	}
	
	public boolean is_newsletter_subscription_input_exists() {
		return (webDriver.findElement(By.cssSelector("#email")) != null);
	}
	
	public void fill_newsletter_subscription_email_input(String emailAddress) {
		webDriver.findElement(By.cssSelector("#email")).sendKeys(emailAddress);;
	}
	
	public void click_newsletter_subscription_submit_button() {
		webDriver.findElement(By.cssSelector("#newsletterFormSubmitBtn")).click();
	}
	
	public boolean is_newsletter_subscription_confirmation_text_displayed() {
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 10);
		WebElement newsletterSubscriptionConfirmationText = 
				webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".footerNewsletter__confirmation")));
		
		return newsletterSubscriptionConfirmationText != null;
	}
	

}
