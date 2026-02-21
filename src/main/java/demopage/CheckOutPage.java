package demopage;

import org.openqa.selenium.By;

public class CheckOutPage {
	private By countrydropdown = By.id("BillingNewAddress_CountryId");
	private By citytextbox = By.id("BillingNewAddress_City");
	private By addresstextbox = By.id("BillingNewAddress_Address1");
	private By postalcodetextbox = By.id("BillingNewAddress_ZipPostalCode");
	private By phonetextbox = By.id("BillingNewAddress_PhoneNumber");
	private By continuebutton = By.xpath("//input[@onclick='Billing.save()']");
	private By shippingcontinuebutton = By.xpath("//input[@onclick='Shipping.save()']");
	private By shippingmethodcontinuebutton = By.xpath("//input[@onclick='ShippingMethod.save()']");
	private By COD = By.xpath("//input[@value='Payments.CashOnDelivery']");
	private By paymentmethodcontinuebutton = By.xpath("//input[@onclick='PaymentMethod.save()']");
	private By paymentinfocontinuebutton = By.xpath("//input[@onclick='PaymentInfo.save()']");
	private By confirmorderbutton = By.xpath("//input[@onclick='ConfirmOrder.save()']");
	private By AR = By.xpath("//strong[text()='Your order has been successfully processed!']");

	public void BillingAddressDetails(String country, String city, String address, String postalcode, String phone) {
		demoutils.SelectUtil.selectByVisibleText(countrydropdown, country);
		demoutils.WaitUtil.checkElementisVisible(citytextbox).sendKeys(city);
		demoutils.WaitUtil.checkElementisVisible(addresstextbox).sendKeys(address);
		demoutils.WaitUtil.checkElementisVisible(postalcodetextbox).sendKeys(postalcode);
		demoutils.WaitUtil.checkElementisVisible(phonetextbox).sendKeys(phone);
		demoutils.WaitUtil.checkElementisVisible(continuebutton).click();
	}

	public void clickShippingContinueButton() {
		demoutils.WaitUtil.checkElementisVisible(shippingcontinuebutton).click();
	}

	public void clickShippingMethodContinueButton() {
		demoutils.WaitUtil.checkElementisVisible(shippingmethodcontinuebutton).click();
	}

	public void selectCODPaymentMethod() {
		demoutils.WaitUtil.checkElementisVisible(COD).click();
		demoutils.WaitUtil.checkElementisVisible(paymentmethodcontinuebutton).click();
	}

	public void clickPaymentInfoContinueButton() {
		demoutils.WaitUtil.checkElementisVisible(paymentinfocontinuebutton).click();
	}

	public void clickConfirmOrderButton() {
		demoutils.WaitUtil.checkElementisVisible(confirmorderbutton).click();
	}

	public String getOrderConfirmationMessage() {
		return demoutils.WaitUtil.checkElementisVisible(AR).getText();
	}
}
