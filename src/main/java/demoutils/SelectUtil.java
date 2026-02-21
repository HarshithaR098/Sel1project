package demoutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtil {

	public static Select getselectUtil(By locator) {
		WebElement element = WaitUtil.checkElementisVisible(locator);
		return new Select(element);

	}
	public static void selectByVisibleText(By locator, String visibleText) {
		getselectUtil(locator).selectByVisibleText(visibleText);
	}

}
