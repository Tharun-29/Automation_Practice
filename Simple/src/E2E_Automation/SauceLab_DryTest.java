package E2E_Automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class SauceLab_DryTest {

	public static void main(String[] args) {
		// Test Case - 1
		
		/*
		  1. Open Sauce Lab Website
		  2. Enter Correct Login Credentials and Navigate to Home Page
		  3. Add Products or Items to the Basket
		  4. Click on Checkout Icon
		  5. Validate All the Items in Checkout Page
		  6. Click on Checkout button
		  7. Enter First Name, Last name and Zip/Postal Code
		  8. Click on continue button
		  9. Navigate to Checkout: Overview Page
		  10. Click on Finish Button
		  11. Navigate to Checkout: Complete Page
		  
		  
		  
		 */
		
		//1. Open Sauce Lab Website
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions builder = new Actions(driver);
        //2. Enter Correct Login Credentials and Navigate to Home Page
		
		
		//Username
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//Password
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
		//Login Button
		driver.findElement(By.id("login-button")).click();
		
		
		
		//3. Add Products or Items to the Basket
	    List<WebElement> Products = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
		
	    for(WebElement Product: Products) {
	    	String productName = Product.getText();
	    	if(productName.contains("Sauce Labs Bike Light") || productName.contains("Backpack")) {
	    		driver.findElement(By.xpath("//div[@data-test='inventory-item-name']/../../following-sibling::div//button[text()='Add to cart']")).click();
	    	}
	    }
	    
	    
	    //4. Click on Checkout Icon
	    driver.findElement(By.id("shopping_cart_container")).click();
	    
	    //5. Validate All the Items in Checkout Page
		List<WebElement> checkOutProducts = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
		
		for(WebElement checkOutProduct: checkOutProducts) {
			if(checkOutProduct.getText().contains("Sauce Labs Bike Light") || checkOutProduct.getText().contains("Backpack")) {
	    		assertTrue(true);
	    	}else {
	    		assertTrue(false);
	    	}
		}
		
		//6. Click on Checkout button
		WebElement checkoutButton = driver.findElement(By.id("checkout"));
		builder.moveToElement(checkoutButton);
		builder.click();
		builder.perform();
		
		
		//Checkout: Your Information page
		// 7. Enter First Name, Last name and Zip/Postal Code
		driver.findElement(By.id("first-name")).sendKeys("Jackie");
		
		driver.findElement(By.id("last-name")).sendKeys("Chan");
		
		driver.findElement(By.id("postal-code")).sendKeys("China");
		
		//8. Click on continue button
		WebElement continueButton = driver.findElement(By.id("continue"));
		builder.moveToElement(continueButton);
		builder.click().perform();
 
		 // 9. Navigate to Checkout: Overview Page
		
		// Validate All the Items in Checkout Page
		List<WebElement> confirmedProducts = driver.findElements(By.xpath("//div[@data-test='inventory-item-name']"));
		for(WebElement confirmedProduct: confirmedProducts) {
			if(confirmedProduct.getText().contains("Sauce Labs Bike Light") || confirmedProduct.getText().contains("Backpack")) {
	    		assertTrue(true);
	    	}else {
	    		assertTrue(false);
	    	}
		}
		
		 // 10. Click on Finish Button
		WebElement finishButton = driver.findElement(By.id("finish"));
		builder.moveToElement(finishButton);
		builder.click().perform();
		
		 // 11. Navigate to Checkout: Complete Page
		String confirmationMessage = driver.findElement(By.xpath("//h2")).getText();
	     assertEquals(confirmationMessage, "Thank you for your order!");
		
	}

}
