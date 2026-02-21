package testRunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import commonutil.AutoGeneratingEmail;
import demopage.HomePage;
import demopage.RegisterPage;

public class RunnerclasswithoutDataprovider extends BaseTest {

	@Test
	public void registerTest() {
		HomePage homePage = new HomePage();
		homePage.clickRegister();
		System.out.println("Clicked on Register link");
		RegisterPage registerPage = new RegisterPage();
		registerPage.registerUser("M","John", "Doe", AutoGeneratingEmail.email(), "Admin@123");
//		registerPage.registerUser(gender, firstName, lastName,email, password);
		String ER="Your registration completed";
		String AR= registerPage.getActualResult();
//		Assert.fail();
		Assert.assertEquals(AR, ER);
		System.out.println("User Registered Successfully");


	}

}
