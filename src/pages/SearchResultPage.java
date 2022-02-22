package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasicPage {

	public SearchResultPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}

	public WebElement getMealsButton() {
		return driver.findElement(By.xpath("//*[contains(@class, 'navs--main')]//li[1]/a"));
	}

	public List<WebElement> getSearchResults() {
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='product-name']/a"));
		return list;
	}

	public int searchResultsNumber() {
		return getSearchResults().size();
	}

	public void searchResultsNames() {
		for (int i = 0; i < getSearchResults().size(); i++) {
			getSearchResults().get(i).getText();
		}

	}

}