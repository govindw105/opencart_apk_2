package pageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Search_Page extends BasePage {

	public Search_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement txtSearchProductName;

	@FindBy(xpath = "//button[@class='btn btn-light btn-lg']")
	WebElement btnSearch;

	@FindBy(xpath = "//div[@class='description']//a[contains(text(),'iPhone')]")
	WebElement lnkiPhone;

	@FindBy(xpath = "//button[@class='btn btn-light btn-lg']")
	WebElement btnAddToCart;
	
	
	@FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
	WebElement lnkShoppingCart;
	
	public void setEmail(String email) {
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void clickLogin() {
		btnLogin.click();
	}

	public void SearchProduct(String SearchProductName) {
		txtSearchProductName.sendKeys(SearchProductName);
	}

	public void clickSearch() {
		btnSearch.click();
	}
	
	public void clickiPhone() {
		lnkiPhone.click();
	}

	public void clickAddToCart() {
		btnAddToCart.click();
	}
	public void clickShoppingCart() {
		lnkShoppingCart.click();
	}
	
	
}
