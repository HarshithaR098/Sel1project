package demoutils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driver.DriverFactory;

public class ActionUtil {

	public static Actions getAction() {
		return new Actions(DriverFactory.getDriver());
	}

	public static void hoverOverElement(By locator) {
		 WebElement element = WaitUtil.checkElementisVisible(locator);
		getAction().moveToElement(element).perform();
	}
	public static void dragAndDropElement(By sourceLocator, By targetLocator) {
		 WebElement sourceElement = WaitUtil.checkElementisVisible(sourceLocator);
		 WebElement targetElement = WaitUtil.checkElementisVisible(targetLocator);
		getAction().dragAndDrop(sourceElement, targetElement).perform();
	}
	public static void rightClickElement(By locator) {
		 WebElement element = WaitUtil.checkElementisVisible(locator);
		getAction().contextClick(element).perform();
	}

}
