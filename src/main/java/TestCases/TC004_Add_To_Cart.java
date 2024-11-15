package TestCases;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.Home_Page;
import pageObject.ProductPage;
import pageObject.Search_Page;
import pageObject.loginPage;
import testBase.BaseClass;

public class TC004_Add_To_Cart extends BaseClass {

	
	@Test(groups= {"Regression", "Master"})
	public void AddToCart() {
		
		logger.info("*******Starting TC004_AddToCard_Test*****");
		
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
			Thread.sleep(2000);
			
			//SearchProduct
			
			Search_Page search = new Search_Page(driver);
			
			search.SearchProduct(p.getProperty("SearchPoductName"));
			
			search.clickSearch();
			
			//ProductPage
			 ProductPage productPage = new ProductPage(driver);
			
			 productPage.scrollToProduct(); // Use the scroll method
			  
			search.clickiPhone();
			
			productPage.scrollToProduct2(); // Use the scroll method
			    
			search.clickAddToCart();
			
			search.clickShoppingCart();
			
			
			//Assert.assertEquals(search, "Shopping Cart (10.00kg)");
			
		   }
		   catch(Exception e)
			{
				logger.error("Test Failed...");
				//logger.debug("Debug logs...");
				Assert.fail();
			}
		   
		   logger.info("*******Finished TC004_AddToCard_Test*****");
			
			
	}
}
