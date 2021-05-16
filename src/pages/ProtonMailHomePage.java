package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProtonMailHomePage {
	
	private WebDriver webDriver;
	private static final String HOME_PAGE_URL = "https://protonmail.com/"; 

	public ProtonMailHomePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void open_page() {
		webDriver.get(HOME_PAGE_URL);
	}
	
	public void click_login_button() {
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15);
		WebElement loginButton = 
				webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='https://mail.protonmail.com/login']")));
		loginButton.click();
	}

}
