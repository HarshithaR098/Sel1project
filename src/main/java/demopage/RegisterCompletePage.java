package demopage;

import org.openqa.selenium.By;

import demoutils.WaitUtil;

public class RegisterCompletePage {
	
	private By registerHeader = By.xpath("//h1[normalize-space()='Register']");
	
    
    private By mandatoryFieldMessage(String label) {
        return By.xpath(
        		"//span[text()='"+label+" is required.' and ancestor::div[@class='inputs']]");         
    }	
    private By ErrorMessage_Email = By.xpath("//span[text()='Wrong email' and ancestor::div[@class='inputs']]");
	private By ErrorMessage_Password = By.xpath("//span[text()='The password should have at least 6 characters.' and ancestor::div[@class='inputs']]");
	public String getRegisterPageHeaderText() {		 
				String AR = WaitUtil.checkElementisVisible(registerHeader).getText();
				return AR;
	}
	
	public String getMandatoryFieldMessage(String label) {
		String AR = WaitUtil.checkElementisVisible(mandatoryFieldMessage(label)).getText();
		return AR;
	}
	public String getErrorMessage_Email() {
		String AR = WaitUtil.checkElementisVisible(ErrorMessage_Email).getText();
		return AR;
	}
	public String getErrorMessage_Password() {
		String AR = WaitUtil.checkElementisVisible(ErrorMessage_Password).getText();
		return AR;
	}
		
}
