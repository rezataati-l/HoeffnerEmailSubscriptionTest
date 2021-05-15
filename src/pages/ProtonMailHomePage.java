package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
		webDriver.findElement(By.cssSelector("a[href='https://mail.protonmail.com/login']")).click();
	}

}
