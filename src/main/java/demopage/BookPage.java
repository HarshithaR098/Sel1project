package demopage;

import org.openqa.selenium.By;

import demoutils.WaitUtil;

public class BookPage {

	private By addToCartButton= By.xpath("(//input[@value='Add to cart'])[1]");

	public void getAddToCartButton() {
		WaitUtil.checkElementisVisible(addToCartButton).click();
	}

}
