package testListeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import demoutils.CurrentDateUtil;
import demoutils.Screenshotutil;
import driver.DriverFactory;

public class Listeners implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test is started "+result.getName());
		
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is passed "+result.getName());
		
	}
	public void onTestFailure(ITestResult result) {
		try {
			Screenshotutil.captureScreenShot(DriverFactory.getDriver(), CurrentDateUtil.getCurrentDate()+result.getName()+".png");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test is failed "+result.getName());
		
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped "+result.getName());
		
	}
}
