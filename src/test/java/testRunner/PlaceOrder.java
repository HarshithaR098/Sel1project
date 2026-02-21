package testRunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import commonutil.AutoGeneratingEmail;
import demopage.BookPage;
import demopage.CheckOutPage;
import demopage.HomePage;
import demopage.LogoutPage;
import demopage.RegisterPage;
import demopage.ShoopingCartPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class PlaceOrder extends BaseTest {
	private static Logger log = LogManager.getLogger(PlaceOrder.class);

	
	@Test
	@Epic("eCommerce Platform")
	@Feature("Order Management")
	@Story("User Registration and Order Placement")
	public void placeOrder() {
		HomePage homePage = new HomePage();
		RegisterPage registerPage = new RegisterPage();
		BookPage bookPage = new BookPage();
		ShoopingCartPage shoppingCartPage = new ShoopingCartPage();
		CheckOutPage checkoutPage = new CheckOutPage();
		homePage.clickRegister();

		registerPage.registerUser("M", "John", "Doe", AutoGeneratingEmail.email(), "Admin@123");
		log.info("User Registered Successfully");

		homePage.clickBooks();
		log.info("Books category selected");

		bookPage.getAddToCartButton();
		homePage.clickShoppingCart();
		log.info("Book added to cart successfully");

		shoppingCartPage.selectCountry("India");
		shoppingCartPage.clickTermsOfService();
		shoppingCartPage.clickCheckoutButton();
		log.info("Proceeding to checkout");

		checkoutPage.BillingAddressDetails("India", "Bangalore", "address", "12345", "9863464544");
		checkoutPage.clickShippingContinueButton();
		log.info("Billing Address details filled successfully");

		checkoutPage.clickShippingMethodContinueButton();
		log.info("Shipping method selected");

		checkoutPage.selectCODPaymentMethod();
		checkoutPage.clickPaymentInfoContinueButton();
		log.info("Payment method selected");
		checkoutPage.clickConfirmOrderButton();
		log.info("Order placed successfully");
		String actualResult = checkoutPage.getOrderConfirmationMessage();
		String expectedResult = "Your order has been successfully processed!";
		Assert.assertEquals(actualResult, expectedResult, "Order confirmation message mismatch");
		log.info("Order confirmation verified");

		LogoutPage logoutPage = new LogoutPage();
		logoutPage.clickLogout();
		log.info("User logged out successfully");
	}
}
