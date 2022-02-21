package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPopupPage extends BasicPage {
	private JavascriptExecutor js;

	public LocationPopupPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait);
		this.js = (JavascriptExecutor) driver;
	}

	public WebElement getLocationMenu() {
		return driver.findElement(By.xpath("//*[@class='location-selector']/a"));
	}

	public WebElement getCloseMenuButton() {
		return driver.findElement(By.className("close-btn close-btn-white"));
	}

	public WebElement getLocationKeyword() {
		return driver.findElement(By.id("locality_keyword"));
	}

	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}

	public WebElement getLocationInput() {
		return driver.findElement(By.id("location_id"));
	}

	public WebElement getSubmitButton() {
		return driver.findElement(By.name("btn_submit"));
	}

	public void openLocationMenu() {
		getLocationMenu().click();
	}

	public void setLocation(String locationName) {
		getLocationKeyword().click();
		WebElement locationItem = getLocationItem(locationName);
		js.executeScript("arguments[0].value=arguments[1];", getLocationInput(), locationItem);
		js.executeScript("argument[0].click;", getSubmitButton());

	}

	public void closePopup() {
		getCloseMenuButton().click();
	}

}
