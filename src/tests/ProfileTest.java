package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {
	
	@Test (priority = 1)
	public void editProfileTest() {
		driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		lPP.closePopup();
		lp.login(this.emailDemo, this.passwordDemo);
		Assert.assertEquals(nsp.getNotificationMessage().contains("Login Successfull"), "[ERROR] Login message did not appear.");
		driver.navigate().to(this.baseUrl + "/member/profile");
	}
}
