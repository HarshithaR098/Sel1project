package demoutils;

import java.io.ByteArrayInputStream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;
import driver.DriverFactory;
import io.qameta.allure.Allure;

public class AllureScreenshotUtil  {
	
//	@Attachment(value = "Failure Screenshot", type = "image/png")
//	public static byte[] takeScreenshot() {
//		TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
//		return ts.getScreenshotAs(OutputType.BYTES);
//		
//	}
	
	public static void takeScreenshot() {
		byte [] ss = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment("Failure Screenshot", new ByteArrayInputStream(ss));
		
	}
	
	public static void attachLog(String log) {
		Allure.addAttachment("Log Attachment", new String (log));
	}


}
