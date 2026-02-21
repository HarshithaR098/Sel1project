package demopage;

import org.openqa.selenium.By;

import base.BaseTest;
import demoutils.WaitUtil;

public class RegisterPage  extends BaseTest {
//	// Personal Details Section
//	private By genderMale = By.xpath("//input[@id='gender-male']");
//	private By genderFemale = By.xpath("//input[@id='gender-female']");
//	private By firstName = By.xpath("//input[@id='FirstName']");
//	private By lastName = By.xpath("//input[@id='LastName']");
//	private By email = By.xpath("//input[@id='Email']");
//
//	// Password Section
//	private By password = By.xpath("//input[@id='Password']");
//	private By confirmPassword = By.xpath("//input[@id='ConfirmPassword']");
//
//	// Buttons
//	private By registerButton = By.xpath("//input[@id='register-button']");

//	private By byId(String id) {
//	    return By.xpath("//input[@id='" + id + "']");
//	}
//	// Personal Details
//	private By genderMale = byId("gender-male");
//	private By genderFemale = byId("gender-female");
//	private By firstName = byId("FirstName");
//	private By lastName = byId("LastName");
//	private By email = byId("Email");
//
//	// Password Section
//	private By password = byId("Password");
//	private By confirmPassword = byId("ConfirmPassword");
//
//	// Button
//	private By registerButton = byId("register-button");

	// Personal Details IDs
	private static final String GENDER_MALE = "gender-male";
	private static final String GENDER_FEMALE = "gender-female";
	private static final String FIRST_NAME = "FirstName";
	private static final String LAST_NAME = "LastName";
	private static final String EMAIL = "Email";

	// Password IDs
	private static final String PASSWORD = "Password";
	private static final String CONFIRM_PASSWORD = "ConfirmPassword";

	// Button ID
	private static final String REGISTER_BUTTON = "register-button";
	private By AR=By.xpath("//div[@class='result']");

	private By byInputId(String id) {
		return By.xpath("//input[@id='" + id + "']");
	}
	public String getActualResult() {
		return WaitUtil.checkElementisVisible(AR).getText();
	}
//	public  String getManadatoryFieldErrorMessage(String fieldname) {
//		WaitUtil.checkElementisVisible(byInputId(FIRST_NAME)).getText();
//		WaitUtil.checkElementisVisible(byInputId(LAST_NAME)).getText();
//		WaitUtil.checkElementisVisible(byInputId(EMAIL)).getText();
//		WaitUtil.checkElementisVisible(byInputId(PASSWORD)).getText();
//		WaitUtil.checkElementisVisible(byInputId(CONFIRM_PASSWORD)).getText();
//
//		WaitUtil.checkElementisVisible(byInputId(REGISTER_BUTTON)).click();
//		return fieldname;
//	}
	
	
	public void clickRegisterButton() {
		WaitUtil.checkElementisVisible(byInputId(REGISTER_BUTTON)).click();
		
	}

	public void registerUser(String gen, String firstNameValue, String lastNameValue, String emailValue,
			String passwordValue) {
		if (gen == "M") {
			WaitUtil.checkElementisVisible(byInputId(GENDER_MALE)).click();
		} else {
			WaitUtil.checkElementisVisible(byInputId(GENDER_FEMALE)).click();
		}
		WaitUtil.checkElementisVisible(byInputId(FIRST_NAME)).sendKeys(firstNameValue);
		WaitUtil.checkElementisVisible(byInputId(LAST_NAME)).sendKeys(lastNameValue);
		WaitUtil.checkElementisVisible(byInputId(EMAIL)).sendKeys(emailValue);
		WaitUtil.checkElementisVisible(byInputId(PASSWORD)).sendKeys(passwordValue);
		WaitUtil.checkElementisVisible(byInputId(CONFIRM_PASSWORD)).sendKeys(passwordValue);
		WaitUtil.checkElementisVisible(byInputId(REGISTER_BUTTON)).click();
	}
	
	public void enterPasswordinvalid(String passwordValue) {
		WaitUtil.checkElementisVisible(byInputId(PASSWORD)).sendKeys(passwordValue);
	}
	public void enterEmailinvalid(String emailValue) {
		WaitUtil.checkElementisVisible(byInputId(EMAIL)).sendKeys(emailValue);
	}

	//usage of ActionUtil
	public void mouseHoverOnRegisterButton() {
		demoutils.ActionUtil.hoverOverElement(byInputId(REGISTER_BUTTON));
	}
	//usage of select util
	public void selectDayOfBirth(String day) {
		demoutils.SelectUtil.selectByVisibleText(byInputId("DateOfBirthDay"), day);
	}

}
