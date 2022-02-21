package tests;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSystemPage;
import pages.SearchResultPage;

public abstract class BasicTest {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected JavascriptExecutor js;
	protected String baseUrl;
	protected String emailDemo;
	protected String passwordDemo;
	protected LocationPopupPage lPP;
	protected LoginPage lp;
	protected NotificationSystemPage nsp;
	protected AuthPage ap;
	protected MealPage mp;
	protected CartSummaryPage csp;
	protected SearchResultPage srp;
	

	public BasicTest() {
		this.baseUrl = "http://demo.yo-meals.com/";
		this.emailDemo = "customer@dummyid.com";
		this.passwordDemo = "12345678a";
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		
		js = (JavascriptExecutor) driver;
		lPP = new LocationPopupPage(driver, wait, js);
		lp = new LoginPage(driver, wait);
		nsp = new NotificationSystemPage(driver, wait);
		ap = new AuthPage(driver,wait, js);
		mp = new MealPage(driver, wait, js);
		csp = new CartSummaryPage(driver, wait, js);
		srp = new SearchResultPage(driver, wait, js);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.navigate().to(baseUrl);

	}


	@AfterMethod
	public void afterMethod(){
		driver.quit();
	}

}
