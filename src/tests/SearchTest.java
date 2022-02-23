package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BasicTest {

	@Test(priority = 1)
	public void searchResultTest() throws IOException {
		File file = new File("./data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals Search Results");

		driver.navigate().to(baseUrl + "/meals");
		lpp.setLocation("Nadeau - Los Angeles");

		for (int i = 1; i <= 5; i++) {
			driver.navigate().to(baseUrl + "/meals");
			
			String url = sheet.getRow(i).getCell(0).getStringCellValue();
			driver.navigate().to(url);
			String location = sheet.getRow(i).getCell(1).getStringCellValue();
			lpp.setLocation(location);
			String numberOfSearch = sheet.getRow(i).getCell(2).getStringCellValue();
			Integer nOfSearch = Integer.valueOf("numberOfSearch");
			
			sa.assertEquals(srp.searchResultsNumber(), numberOfSearch,
					"[ERROR] Search result does not match with compared data.");
			
			for (int j = 3; j < 3 + nOfSearch; j++) {
				String mealsSearched = sheet.getRow(i).getCell(j).getStringCellValue();
				sa.assertTrue(srp.searchResultCompare(mealsSearched),
						"[ERROR] Search result is not in same order as compared data");
			}

		}

		sa.assertAll();
	}

}
