package demoutils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.ApplicationContants;
import driver.DriverFactory;

public class WaitUtil  implements ApplicationContants{
//	public static WebDriver driver;
//	private static final int TIMEOUT = 10;

	public static WebElement checkElementisVisible(By locator) {
		return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(TIMEOUT))
				.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}


}
