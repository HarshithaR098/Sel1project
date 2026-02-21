package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import demoutils.AllureScreenshotUtil;
import demoutils.Readconfig;
//import demoutils.WaitUtil;
import driver.DriverFactory;

public class BaseTest {
	public WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void setUp(@Optional String browser) throws IOException {
//		if(browser!=null) {
//			DriverFactory.intiDriver(browser);
//		}
////		else {
////			DriverFactory.intiDriver(Readconfig.getFromproperty("browser"));
////		}
//	DriverFactory.intiDriver(browser==null ? Readconfig.getFromproperty("browser") : browser);
		if (browser == null) {
			browser = Readconfig.getFromproperty("browser");
		}
		boolean headless = Boolean.parseBoolean(Readconfig.getFromproperty("headless"));
		DriverFactory.intiDriver(browser, headless);
		driver = DriverFactory.getDriver();
		driver.manage().window().maximize();
		driver.get(Readconfig.getFromproperty("url"));
//		driver.get("https://demowebshop.tricentis.com/");

//		driver= new ChromeDriver();
////		WaitUtil.driver = driver;
//		driver.manage().window().maximize();
//		driver.get(Readconfig.getApplicationURL("url"));
	}

	
//	@AfterMethod
//    public void tearDown(ITestResult result) {
//
//        if (result.getStatus() == ITestResult.FAILURE) {
//            AllureScreenshotUtil.takeScreenshot();
//        }
//
//        DriverFactory.quitDriver();
//    }
	@AfterMethod
	public void tearDown() {
		DriverFactory.quitDriver();

//		driver.quit();
	}

}
