package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSystemPage extends BasicPage {
	public NotificationSystemPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public WebElement getMsgShowed() {
		return driver
				.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')]"));
	}

	public String getNotificationMessage() {
		return driver
				.findElement(By.xpath("//*[contains(@class, 'alert--success') or contains(@class, 'alert--danger')]"))
				.getText();
	}

	public void waitForMsgDisappearance() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.attributeToBe(By.xpath(" //*[contains(@class, 'system_message')]"), "style",
				"display: none;"));
	}

	public void waitForMsgAppereance() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.attributeToBe(By.xpath(" //*[contains(@class, 'system_message')]"), "style",
				"display: block;"));
	}

}
