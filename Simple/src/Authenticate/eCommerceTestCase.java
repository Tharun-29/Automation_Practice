package Authenticate;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class eCommerceTestCase {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        Actions actions = new Actions(driver);
        
        String productToPurchase = "iphone 12 black";
        
        // Open Flipkart
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']")).sendKeys(productToPurchase + Keys.ENTER);
        
        List<WebElement> productItems = driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
        productItems.get(0).click();
        
    
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        
        String productLink = driver.getCurrentUrl();
        
        driver.switchTo().window(childWindow);
        
        String productName = driver.findElement(By.xpath("//span[text()='Apple iPhone 12 (Black, 64 GB)']")).getText();
        String productPriceInFlipkart = driver.findElement(By.cssSelector("div.Nx9bqj.CxhGGd")).getText();
        
        
        
        WebElement addToCartButton = driver.findElement(By.xpath("//button[text()='Add to cart']"));
        actions.moveToElement(addToCartButton).click().perform();
        
        Thread.sleep(2000);
        
        // Navigate to the Buy Now Screen
        driver.findElement(By.cssSelector("button.QqFHMw.zA2EfJ._7Pd1Fp")).click();
        
        // Print product details
        System.out.println("Product Name: " + productName);
        System.out.println("Product Link: " + productLink);
        System.out.println("Product Price in Flipkart: " + productPriceInFlipkart);
        
        // Close the browser
        driver.quit();
    }
}
