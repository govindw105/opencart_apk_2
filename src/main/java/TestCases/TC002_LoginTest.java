package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Home_Page;
import pageObject.MyAccountPage;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups= {"Sanity", "Master"})
	public void verify_login() {
		logger.info("*******Starting TC_002_LoginTest*****");
		
		
		try
		{
		//HomePage
		Home_Page hp = new Home_Page(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		loginPage lp = new loginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		//Assert.assertEquals(targetPage, true,  "Login failed");
		Assert.assertTrue(targetPage);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
				
		logger.info("*******Finished TC_002_LoginTest*****");
	}
	
}
