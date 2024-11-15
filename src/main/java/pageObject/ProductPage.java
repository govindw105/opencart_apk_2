package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void scrollToProduct() {
        WebElement element = driver.findElement(By.xpath("//div[@class='description']//a[contains(text(),'iPhone')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void scrollToProduct2() {
    	WebElement element2= driver.findElement(By.xpath("//button[@class='btn btn-light btn-lg']"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
    	wait.until(ExpectedConditions.visibilityOf(element2));
    }

    // Other methods related to the Product Page
}
