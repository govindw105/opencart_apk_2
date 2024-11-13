package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Home_Page;
import pageObject.MyAccountPage;
import pageObject.loginPage;
import testBase.BaseClass;
import utilities.DataProviders;
  
/*
  Data is valid - login success - test pass --logout 
                   login failed - test fail
 
  Data is invalid - login success - test fail - logout 
                    login failed - test pass
 */

public class TC003_Login_DDT extends BaseClass {
	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class, groups= {"Datadriven"}) //getting DataProiders from different class
	public void verify_loginDDT(String email, String pwd, String exp) throws Exception {
		
  		logger.info("******Started TC_003_LoginDDT******");
		
  		try {
		//HomePage
		Home_Page hp = new Home_Page(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		loginPage lp = new loginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
	
		
		//MyAccountPage
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		
		/*
		  Data is valid - login success - test pass --logout 
		                   login failed - test fail
		 
		  Data is invalid - login success - test fail - logout 
		                    login failed - test pass
		 */
		
		
		if (exp.equalsIgnoreCase("Valid")) {
			
			if(targetPage == true) {
				Assert.assertTrue(true);
				macc.clickLogout();
				macc.clickContinue();
			}else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) 
		{ 
		  if(targetPage == true) 
		  {
			  macc.clickLogout();
				macc.clickContinue();
			  Assert.assertTrue(false);
		  }	
			
		}else {
			Assert.assertTrue(true);
		}
		
  		}catch(Exception e) {
  			Assert.fail();
  		}
		
  		Thread.sleep(3000);
      logger.info("******Finished TC_003_LoginDDT******");
		
	}


}
