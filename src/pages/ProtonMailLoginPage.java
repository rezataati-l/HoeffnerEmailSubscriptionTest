package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProtonMailLoginPage {
	
	private WebDriver webDriver;

	public ProtonMailLoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void login() {
		webDriver.findElement(By.cssSelector("#username")).sendKeys("linkmail001");
		webDriver.findElement(By.cssSelector("#password")).sendKeys("Link123");
		webDriver.findElement(By.cssSelector("#login_btn")).click();
	}

}
