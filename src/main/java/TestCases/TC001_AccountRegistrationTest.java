package TestCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.Home_Page;
import testBase.BaseClass;
import pageObject.AccountRegistrationPage;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	
	@Test(groups= {"Regression", "Master"})
	public void verfy_account_registration() {
		
		logger.info("*******Starting TC001_AccountRegistrationTest*****");
		
		
		try 
		{
		Home_Page hp = new Home_Page(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link...");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link...");
		
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString() + "@gmail.com");
		
		String password = randomeAlphaNumberic();
		
		regpage.setPassword(password);
		
		regpage.setSubscribe();
		
		regpage.setPrivacyPolicy();
 		
		regpage.clickContinue();
		
		logger.info("Validating expected message...");
		
		String confmsg = regpage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
		
		
		}
		catch(Exception e)
		{
			logger.error("Test Failed...");
			//logger.debug("Debug logs...");
			Assert.fail();
		}
		
		logger.info("*****FInished TC001_AccountRegistrationTest******");
		
	}
	
	

}
