package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UnsubscribePage {

	private WebDriver webDriver;

	public UnsubscribePage(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	public void unsubscribe() {
		WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15);
		webDriverWait.until(ExpectedConditions.titleContains("Abmelden"));
		webDriver.findElement(By.cssSelector("input[value='Abmelden']")).click();
	}
}
