package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MealPage extends BasicPage {
	private JavascriptExecutor js;

	public MealPage(WebDriver driver, WebDriverWait wait, JavascriptExecutor js) {
		super(driver, wait);
		this.js = (JavascriptExecutor) driver;
	}

	public WebElement getMealsButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'navs--main')]//li[1]/a"));
	}

	public WebElement getProduct(int index) {
		return driver.findElement(By.xpath("//*[@id='listing']/div[" + index +"]/div/div[2]/div[2]/a"));
	}

	public WebElement getQuantityInput() {
		return driver.findElement(By.name("product_qty"));
	}

	public WebElement getAddToCartButton() {
		return driver
				.findElement(By.xpath("//*[contains(@class, 'btn btn--primary btn--large js-proceedtoAddInCart ')]"));
	}

	public WebElement getFavouriteButton(int index) {
		return driver.findElement(By.xpath("//*[@id='listing']/div["+ index +"]//a"));
	}

	public void addProductToTheCart(String quantity, int index){
		getMealsButton().click();
		js.executeScript("arguments[0].click();", getProduct(index));
		getQuantityInput().clear();
		getQuantityInput().sendKeys(Keys.chord(Keys.CONTROL, "a"));
		getQuantityInput().sendKeys(quantity);
		getAddToCartButton().click();
	}

	public void addToFavourite(int index) {
		getMealsButton().click();
		js.executeScript("arguments[0].click();", getFavouriteButton(index));
	}

}
