package testRunner;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import dataproviderExcel.DataProvideExcel;
import demopage.HomePage;
import demopage.RegisterPage;

public class RunnerRegister extends BaseTest {

	@Test(dataProvider="exceldata", dataProviderClass=DataProvideExcel.class)
	public void registerTest(String gender , String firstName,String lastName ,String email, String password) {
		HomePage homePage = new HomePage();
		homePage.clickRegister();
		System.out.println("Clicked on Register link");
		RegisterPage registerPage = new RegisterPage();
//		registerPage.registerUser("M","John", "Doe", AutoGeneratingEmail.email(), "Admin@123");
		registerPage.registerUser(gender, firstName, lastName,email, password);
		String ER="Your registration completed";
		String AR= registerPage.getActualResult();
		Assert.assertEquals(AR, ER);
		System.out.println("User Registered Successfully");


	}

}
