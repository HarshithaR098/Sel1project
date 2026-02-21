package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

	static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public static void intiDriver(String browser , boolean headless) {
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			if(headless) {
				options.addArguments("--headless=new");
			}
			tlDriver.set(new ChromeDriver(options));

		}
		else if(browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			if(headless) {
				options.addArguments("--headless");
			}
			tlDriver.set(new FirefoxDriver(options));
		}
		else if(browser.equalsIgnoreCase("edge")) {
			tlDriver.set(new EdgeDriver());
		}

	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void quitDriver() {
//		tlDriver.get().quit();
//		tlDriver.remove();
//	
	if (tlDriver.get() != null) {
        tlDriver.get().quit();
        tlDriver.remove();
    }
	}

}
