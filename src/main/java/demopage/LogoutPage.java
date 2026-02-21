package demopage;

import org.openqa.selenium.By;

import demoutils.WaitUtil;

public class LogoutPage {
	private By logout=By.xpath("//a[@class='ico-logout']");

	public void clickLogout() {
	 WaitUtil.checkElementisVisible(logout).click();
	}

}
