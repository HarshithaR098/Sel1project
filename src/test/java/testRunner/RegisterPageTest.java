package testRunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import demopage.HomePage;
import demopage.RegisterCompletePage;
import demopage.RegisterPage;
import demoutils.AllureScreenshotUtil;

public class RegisterPageTest extends BaseTest {
	HomePage hp;
	RegisterCompletePage registerPage;
	RegisterPage rp;
	private static final Logger log =  LogManager.getLogger(Registerwithrandomemailandallurelog.class);
	
	@Test(priority=1)
	public void Header() {
		log.info("Verifying Register Page Header");
		registerPage = new RegisterCompletePage();
		hp = new HomePage();
		hp.clickRegister();
		String AR = registerPage.getRegisterPageHeaderText();
		String ER = "Register";
		Assert.assertEquals(AR, ER);
		AllureScreenshotUtil.attachLog("Register Page Header Verified Successfully");

	}

	@Test(priority=2)
	public void CheckMandatoryFields() {
		hp = new HomePage();
		hp.clickRegister();
		rp = new RegisterPage();
		rp.clickRegisterButton();
		log.info("Verifying Mandatory Field Messages");
		registerPage = new RegisterCompletePage();
		String AR = registerPage.getMandatoryFieldMessage("First name");
		String ER = "First name is required.";
		AllureScreenshotUtil.attachLog("Verified Mandatory Field Messages for First Name");
		Assert.assertEquals(AR, ER);
		String AR1 = registerPage.getMandatoryFieldMessage("Last name");
		String ER1 = "Last name is required.";
		AllureScreenshotUtil.attachLog("Verified Mandatory Field Messages for Last Name");
		Assert.assertEquals(AR1, ER1);
		String AR2 = registerPage.getMandatoryFieldMessage("Email");
		String ER2 = "Email is required.";
		Assert.assertEquals(AR2, ER2);
		AllureScreenshotUtil.attachLog("Verified Mandatory Field Messages for Email");
		String AR3 = registerPage.getMandatoryFieldMessage("Password");
		String ER3 = "Password is required.";
		Assert.assertEquals(AR3, ER3);
		AllureScreenshotUtil.attachLog("Verified Mandatory Field Messages for Password");
		String AR4 = registerPage.getMandatoryFieldMessage("Password");
		String ER4 = "Password is required.";
		AllureScreenshotUtil.attachLog("Verified Mandatory Field Messages for Confirm Password");
		Assert.assertEquals(AR4, ER4);
		AllureScreenshotUtil.attachLog("Mandatory Field Messages Verified Successfully");
		log.info("Mandatory Field Messages Verified Successfully");
		

	}
	
	@Test(priority=3)
	public void CheckInvalidEmailandPassword() {
		hp = new HomePage();
		hp.clickRegister();
		rp = new RegisterPage();
		rp.enterEmailinvalid("invalidemail");
		rp.enterPasswordinvalid("123");
		rp.clickRegisterButton();
		
		log.info("Verifying Error Messages for Invalid Email and Password");
		registerPage = new RegisterCompletePage();
		String AR = registerPage.getErrorMessage_Email();
		String ER = "Wrong email";
		Assert.assertEquals(AR, ER);
		AllureScreenshotUtil.attachLog("Verified Error Message for Invalid Email");
		String AR1 = registerPage.getErrorMessage_Password();
		String ER1 = "The password should have at least 6 characters.";
		Assert.assertEquals(AR1, ER1);
		AllureScreenshotUtil.attachLog("Verified Error Message for Invalid Password");
		log.info("Error Messages for Invalid Email and Password Verified Successfully");
	}
	
	

}
