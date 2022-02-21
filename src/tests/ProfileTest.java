package tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	@Test(priority = 1)
	public void editProfileTest() {
		driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		lPP.closePopup();
		lp.login(this.emailDemo, this.passwordDemo);
		Assert.assertEquals(nsp.getNotificationMessage().contains("Login Successfull"),
				"[ERROR] Login message did not appear.");

		driver.navigate().to(this.baseUrl + "/member/profile");
		pp.addPersonalInformation("Marcus", "Miois", "2045 W Jackson Blvd", "217-335-2682", "60601", "US", "IL",
				"Chicago");
		Assert.assertTrue(nsp.getNotificationMessage().contains("Setup Successful"),
				"[ERROR] Setup message did not appear.");
		nsp.waitForMsgDisappearance();
		ap.logOut();
		Assert.assertTrue(nsp.getNotificationMessage().contains("Logout Successfull!"),
				"[ERROR] Logout message did not appear.");
	}

	@Test(priority = 2)
	public void changeProfileImageTest() throws IOException {
		driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		lPP.closePopup();
		lp.login(this.emailDemo, this.passwordDemo);
		Assert.assertEquals(nsp.getNotificationMessage().contains("Login Successfull"),
				"[ERROR] Login message did not appear.");

		String imgPath = new File("imagеs/237-536x354.jpg").getCanonicalPath();
		driver.navigate().to(this.baseUrl + "/member/profile");
		pp.uploadPhoto(imgPath);
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
