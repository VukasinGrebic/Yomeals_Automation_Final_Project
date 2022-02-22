package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage {

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public WebElement getUsername() {
		return driver.findElement(By.name("username"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}

	public WebElement getRememberMeButton() {
		return driver.findElement(By.name("remember_me"));
	}

	public WebElement getLoginButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'filled')]/a"));
	}

	public void login(String email, String password) {
		getUsername().clear();
		getUsername().sendKeys(email);
		getPassword().clear();
		getPassword().sendKeys(password);
		getLoginButton().click();
	}

}
