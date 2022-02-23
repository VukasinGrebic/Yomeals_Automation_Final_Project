package pages;

import java.util.ArrayList;
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

	public List<WebElement> getSearchResults() {
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='product-name']/a"));
		return list;
	}

	public int searchResultsNumber() {
		return getSearchResults().size();
	}

	public ArrayList<String> searchResultsNames() {
		ArrayList<String> list = new ArrayList<String>();
		for (int i = 0; i < getSearchResults().size(); i++) {
			String n = getSearchResults().get(i).getText();
			list.add(n);
		}
		return list;
	}

	public boolean searchResultCompare(String mealsSearched) {
		int counter = 0;
		for (int i = 0; i < searchResultsNumber(); i++) {
			if (searchResultsNames().get(i).equals(mealsSearched)) {
				counter = counter + 1;
			}
		}
		if (counter == searchResultsNumber()) {
			return true;
		} else {
			return false;
		}
	}

}