package testRunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
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

public class PlaceOrderUser extends BaseTest {
	private static Logger log = LogManager.getLogger(PlaceOrder.class);
	HomePage homePage;
	RegisterPage registerPage;
	BookPage bookPage;
	ShoopingCartPage shoppingCartPage;
	CheckOutPage checkoutPage;
	LogoutPage logoutPage;

	@Test
	@Epic("eCommerce Platform")
	@Feature("Order Management")
	@Story("User Registration and Order Placement")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test to verify complete order placement flow from user registration to order confirmation")
	public void placeOrder() {
		homePage = new HomePage();
		registerPage = new RegisterPage();
		bookPage = new BookPage();
		shoppingCartPage = new ShoopingCartPage();
		checkoutPage = new CheckOutPage();
		logoutPage = new LogoutPage();

		clickRegisterButton();
		registerNewUser("M", "John", "Doe", AutoGeneratingEmail.email(), "Admin@123");

		selectBooksCategory();
		addBookToCart();

		proceedToCheckout();
		fillBillingAddress("India", "bangalore", "asdfg", "560058", "9880482459");

		selectShippingMethod();
		selectPaymentMethod();

		confirmOrder();
		verifyOrderConfirmation();
 
		logoutUser();
	}

	@Step("Click on Register button")
	public void clickRegisterButton() {
		homePage.clickRegister();
		log.info("Clicked Register button");
	}

	@Step("Register new user with email: {email}")
	public void registerNewUser(String title, String firstName, String lastName, String email, String password) {
		registerPage.registerUser(title, firstName, lastName, email, password);
		log.info("User Registered Successfully");
	}

	@Step("Navigate to Books category")
	public void selectBooksCategory() {
		homePage.clickBooks();
//		Assert.fail();
		log.info("Books category selected");
	}

	@Step("Add book to shopping cart")
	public void addBookToCart() {
		bookPage.getAddToCartButton();
		homePage.clickShoppingCart();
		log.info("Book added to cart successfully");
	}

	@Step("Proceed to checkout with country selection")
	public void proceedToCheckout() {
		shoppingCartPage.selectCountry("India");
		shoppingCartPage.clickTermsOfService();
		shoppingCartPage.clickCheckoutButton();
		log.info("Proceeding to checkout");
	}

	@Step("Fill billing address with country: {country}, city: {city}, postal code: {postalCode}")
	public void fillBillingAddress(String country, String city, String address, String postalCode, String phone) {
		checkoutPage.BillingAddressDetails(country, city, address, postalCode, phone);
		checkoutPage.clickShippingContinueButton();
		log.info("Billing Address details filled successfully");
	}

	@Step("Select shipping method")
	public void selectShippingMethod() {
		checkoutPage.clickShippingMethodContinueButton();
		log.info("Shipping method selected");
	}

	@Step("Select COD payment method")
	public void selectPaymentMethod() {
		checkoutPage.selectCODPaymentMethod();
		checkoutPage.clickPaymentInfoContinueButton();
		log.info("Payment method selected");
	}

	@Step("Confirm order placement")
	public void confirmOrder() {
		checkoutPage.clickConfirmOrderButton();
		log.info("Order placed successfully");
	}

	@Step("Verify order confirmation message")
	public void verifyOrderConfirmation() {
		String actualResult = checkoutPage.getOrderConfirmationMessage();
		String expectedResult = "Your order has been successfully ";
		Assert.assertEquals(actualResult, expectedResult, "Order confirmation message mismatch");
		log.info("Order confirmation verified");
	}

	@Step("Logout user")
	public void logoutUser() {
		logoutPage.clickLogout();
		log.info("User logged out successfully");
	}

}
