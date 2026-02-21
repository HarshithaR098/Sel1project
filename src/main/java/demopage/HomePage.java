package demopage;

import org.openqa.selenium.By;

import demoutils.WaitUtil;

public class HomePage {
//	public WebDriver driver;
	private By register = By.xpath("//a[@class='ico-register']");
	private By books = By.xpath("//div[@class='header-menu']//ul[@class='top-menu']//a[normalize-space()='Books']");
	private By shoppingcart = By.xpath("//span[normalize-space()='Shopping cart']");

//	public HomePage(WebDriver driver) {
//		this.driver = driver;
//	}

	public void clickRegister() {
		WaitUtil.checkElementisVisible(register).click();
	}

	public void clickBooks() {
		WaitUtil.checkElementisVisible(books).click();
	}

	public void clickShoppingCart() {
		WaitUtil.checkElementisVisible(shoppingcart).click();
	}
}
