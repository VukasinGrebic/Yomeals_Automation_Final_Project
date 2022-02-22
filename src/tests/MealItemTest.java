package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest {
	
	@Test (priority=1)
	public void addMealToCartTest () {
		driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo"); 
		lpp.closePopup();
		mp.addProductToTheCart("5", 3);
		nsp.waitForMsgAppereance();
		Assert.assertTrue(nsp.getNotificationMessage().contains("Errors"),
				"[ERROR] Location error message did not appear.");
		nsp.waitForMsgDisappearance();
		lpp.openLocationMenu();
		lpp.setLocation("Arbor Hill - Albany");
		driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo"); 
		mp.addProductToTheCart("3", 2);
		nsp.waitForMsgAppereance();
		Assert.assertTrue(nsp.getNotificationMessage().contains("Meal Added"), "[ERROR] Added to cart message did not appear.");
	}
	@Test (priority=2)
	public void addMealToFavoriteTest () {
		driver.navigate().to(baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		lpp.closePopup();
		mp.addToFavourite(2);
		nsp.waitForMsgAppereance();
		Assert.assertTrue(nsp.getNotificationMessage().contains( "Please login"), "[ERROR] Error login message did not appear.");
		nsp.waitForMsgDisappearance();
		lp.getLoginButton().click();
		lp.login(this.emailDemo, super.passwordDemo);
		driver.navigate().to(baseUrl + "/lobster-shrimp-chicken-quesadilla-combo");
		mp.addToFavourite(1);
		nsp.waitForMsgAppereance();
		Assert.assertTrue(nsp.getNotificationMessage().contains("added"),
				"[ERROR] Added to favourite message did not appear.");
	}
	@Test(priority = 3)
	public void clearCartTest() throws IOException {
		File file = new File("./data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals");

		driver.navigate().to(baseUrl + "/meals");
		lpp.setLocation("Nadeau - Los Angeles");

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			String url = sheet.getRow(i).getCell(0).getStringCellValue();
			driver.navigate().to(url);
			mp.addProductDirectlyToTheCart("i");
			nsp.waitForMsgAppereance();
			sa.assertTrue(nsp.getNotificationMessage().contains("Meal Added"),
					"[ERROR] Added to cart message did not appear.");
			nsp.waitForMsgDisappearance();
		}
		
		sa.assertAll();

		csp.clearAll();
		nsp.waitForMsgAppereance();
		Assert.assertTrue(nsp.getNotificationMessage().contains("removed"),
				"[ERROR] Meals removed from the cart message did not appear.");
	}
}
