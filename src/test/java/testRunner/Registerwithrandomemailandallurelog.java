package testRunner;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import demopage.HomePage;
import demopage.RegisterPage;
import demoutils.AllureScreenshotUtil;
import org.apache.logging.log4j.Logger; 

public class Registerwithrandomemailandallurelog extends BaseTest {
//	private static final Logger log =  LogManager.getLogger(Registerwithrandomemailandallurelog.class);

	@Test //(retryAnalyzer = testListeners.RetryAnalyzer.class)
	public void registerTest() {
		String email = RandomStringUtils.randomAlphanumeric(5) + "@gmail.com";
		HomePage homePage = new HomePage();
		homePage.clickRegister();
		System.out.println("Clicked on Register link");
		RegisterPage registerPage = new RegisterPage();
//		log.info("Filling the Registration form with emial: " + email);
		AllureScreenshotUtil.attachLog("Filling the Registration form with emial: " + email);
//			registerPage.registerUser("M","John", "Doe", AutoGeneratingEmail.email(), "Admin@123");
		registerPage.registerUser("M", "Admin", "Dore", email, "admin@123");
		String ER = "Your registration completed";
		String AR = registerPage.getActualResult();
		Assert.assertEquals(AR, ER);
//		log.info("Registration completed successfully with email: " + email);
		AllureScreenshotUtil.attachLog("Registration completed successfully with email: " + email);

	}
	
	

}
