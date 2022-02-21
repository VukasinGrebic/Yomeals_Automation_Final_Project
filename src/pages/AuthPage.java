package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthPage extends BasicPage {
	private JavascriptExecutor js;

	public AuthPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait);
		this.js = (JavascriptExecutor) driver;
	}

	public WebElement getAuthButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'after-arrow user-trigger-js user-trigger-active')]"));
	}

	public WebElement getMyAccountButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'my-account-dropdown')]//li[1]/a"));
	}

	public WebElement getLogOutButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'my-account-dropdown')]//li[2]/a"));
	}
	
	public WebElement getProfileButton() {
		return driver.findElement(By.xpath("//*[@id = 'fixed__panel']//li[2]/a"));
	}
	
	public void goToProfilePage() {
		js.executeScript("arguments[0].click();", getMyAccountButton());
		getProfileButton().click();
	}

	public void logOut() {
		js.executeScript("arguments[0].click();", getLogOutButton());
	}
	
	

}
