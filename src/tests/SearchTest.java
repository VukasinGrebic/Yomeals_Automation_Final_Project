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
	public void clearCartTest() throws IOException {
		File file = new File("./data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meals Search Results");

		driver.navigate().to(baseUrl + "/meals");
		lpp.setLocation("Nadeau - Los Angeles");

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			String location = sheet.getRow(i).getCell(0).getStringCellValue();
			String url = sheet.getRow(i).getCell(1).getStringCellValue();
			String numberOfSearch = sheet.getRow(i).getCell(2).getStringCellValue();

			driver.navigate().to(url);
			lpp.setLocation(location);
			nsp.waitForMsgAppereance();
			sa.assertEquals(srp.searchResultsNumber(), numberOfSearch,
					"[ERROR] Search result does not match with compared data.");
			;

		}

		sa.assertAll();
	}

}
