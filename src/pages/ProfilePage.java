package pages;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {
	private JavascriptExecutor js;

	public ProfilePage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait);
		this.js = (JavascriptExecutor) driver;
	}

	public WebElement getUploadPhotoButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'upload uploadFile-Js')]"));
	}

	public WebElement getRemovePhotoButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'remove')]"));
	}

	public WebElement getFirstNameInput() {
		return driver.findElement(By.name("user_first_name"));
	}

	public void scrollIntoViewFirstName() {
		js.executeScript("arguments[0].scrollIntoView;", getFirstNameInput());
	}

	public WebElement getLastNameInput() {
		return driver.findElement(By.name("user_last_name"));
	}

	public WebElement getAdressInput() {
		return driver.findElement(By.name("user_address"));
	}

	public WebElement getPhoneNumberInput() {
		return driver.findElement(By.name("user_phone"));
	}

	public WebElement getZipCodeInput() {
		return driver.findElement(By.name("user_zip"));
	}

	public void selectCountry(String country) {
		Select dropdownCountry = new Select(driver.findElement(By.id("user_country_id")));
		dropdownCountry.selectByVisibleText(country);
	}

	public void selectState(String state) {
		Select dropdownState = new Select(driver.findElement(By.id("user_state_id")));
		dropdownState.selectByVisibleText(state);
	}

	public void selectCity(String city) {
		Select dropdownCity = new Select(driver.findElement(By.id("user_city")));
		dropdownCity.selectByVisibleText(city);
	}
	
	public void scrollIntoViewPersonalInformationSaveButton() {
		js.executeScript("arguments[0].scrollIntoView;", getPersonalInformationSaveButton());
	}

	public WebElement getPersonalInformationSaveButton() {
		return driver.findElement(
				By.xpath("//*[contains(@class, 'col-lg-12 col-md-12 col-sm-12 col-lg-12 align--right')]//input"));
	}
	
	public WebElement getProfilePhotoUpload () {
		return driver.findElement(By.name("file"));
	}

	public void uploadPhoto(String pathToThePicture) {
		File profilePhoto = new File(pathToThePicture);
		js.executeScript("arguments[0].click();", getUploadPhotoButton());
		WebElement profilePhotoUpload = driver.findElement(By.name("file"));
		profilePhotoUpload.sendKeys(profilePhoto.getAbsolutePath());
		

	}

	public void removePhoto() {
		js.executeScript("arguments[0].click();", getRemovePhotoButton());
	}

	public void addPersonalInformation(String firstName, String lastName, String adress, String phoneNumber,
			String zipCode, String country, String state, String city) {
		scrollIntoViewFirstName();
		getFirstNameInput().clear();
		getFirstNameInput().sendKeys(firstName);
		getLastNameInput().clear();
		getLastNameInput().sendKeys(lastName);
		getAdressInput().clear();
		getAdressInput().sendKeys(adress);
		getPhoneNumberInput().clear();
		getPhoneNumberInput().sendKeys(phoneNumber);
		getZipCodeInput().clear();
		getZipCodeInput().sendKeys(zipCode);
		selectCountry(country);
		selectState(state);
		selectCity(city);
		scrollIntoViewPersonalInformationSaveButton();
		js.executeScript("arguments[0].click();", getPersonalInformationSaveButton());
	}

}