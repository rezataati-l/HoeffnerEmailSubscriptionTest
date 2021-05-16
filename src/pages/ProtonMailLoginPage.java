package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProtonMailLoginPage {
	
	private WebDriver webDriver;

	public ProtonMailLoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void login() {
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='User login']")));
		
		webDriver.findElement(By.cssSelector("#username")).sendKeys("linkmail001");
		webDriver.findElement(By.cssSelector("#password")).sendKeys("Krieger");
		webDriver.findElement(By.cssSelector("#login_btn")).click();
	}

}
