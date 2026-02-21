package demopage;

import org.openqa.selenium.By;

public class ShoopingCartPage {

	private By contrydropdown = By.id("CountryId");
	private By termsofservicecheckbox = By.id("termsofservice");
	private By checkoutbutton = By.id("checkout");

	public void selectCountry(String countryName) {
		demoutils.SelectUtil.selectByVisibleText(contrydropdown, countryName);
	}

	public void clickTermsOfService() {
		demoutils.WaitUtil.checkElementisVisible(termsofservicecheckbox).click();
	}

	public void clickCheckoutButton() {
		demoutils.WaitUtil.checkElementisVisible(checkoutbutton).click();
	}
}
