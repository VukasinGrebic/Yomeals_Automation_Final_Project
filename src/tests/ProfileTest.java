package tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	@Test(priority = 1)
	public void editProfileTest() {
		driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		lpp.closePopup();
		lp.login(this.emailDemo, this.passwordDemo);
		Assert.assertTrue(nsp.getNotificationMessage().contains("Successfull"),
				"[ERROR] Login message did not appear.");

		driver.navigate().to(this.baseUrl + "/member/profile");
		pp.addPersonalInformation("Marcus", "Miois", "2045 W Jackson Blvd", "217-335-2682", "60601", "United States", "California",
				"Lodi");
		Assert.assertTrue(nsp.getNotificationMessage().contains("Setup"),
				"[ERROR] Setup message did not appear.");
		nsp.waitForMsgDisappearance();
		ap.logOut();
		Assert.assertTrue(nsp.getNotificationMessage().contains("Logout Successfull!"),
				"[ERROR] Logout message did not appear.");
	}

	@Test(priority = 2)
	public void changeProfileImageTest() throws IOException {
		driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		lpp.closePopup();
		lp.login(this.emailDemo, this.passwordDemo);
		Assert.assertTrue(nsp.getNotificationMessage().contains("Successfull"),
				"[ERROR] Login message did not appear.");

		
		driver.navigate().to(this.baseUrl + "/member/profile");
		pp.uploadPhoto("img/237-536x354.jpg");
		Assert.assertTrue(nsp.getNotificationMessage().contains("Profile Image Uploaded Successfully"),
				"[ERROR] Image upload message did not appear.");
		nsp.waitForMsgDisappearance();
		pp.removePhoto();
		Assert.assertTrue(nsp.getNotificationMessage().contains("Profile Image Deleted Successfully"),
				"[ERROR] Image remove message did not appear.");

		nsp.waitForMsgDisappearance();
		ap.logOut();
		Assert.assertTrue(nsp.getNotificationMessage().contains("Logout Successfull!"),
				"[ERROR] Logout message did not appear.");
	}

}
