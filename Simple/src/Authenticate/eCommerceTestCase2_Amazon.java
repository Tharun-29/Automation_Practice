package Authenticate;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class eCommerceTestCase2_Amazon {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));// 10 seconds wait time
        
        String productToPurchase = "iphone 12 black";
        driver.get("https://www.amazon.in/");
        
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys(productToPurchase + Keys.ENTER);
        
        WebElement firstProduct = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(//span[contains(@class,'a-size-medium a-color-base')])[1]")
        ));
        String productName = firstProduct.getText();
        System.out.println(productName);
        String productLink = driver.getCurrentUrl();
        System.out.println(productLink);
        
        String selectedProduct = firstProduct.getText();
        firstProduct.click();
        
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();
        driver.switchTo().window(childWindow);
        
        // Add to cart
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//input[@id='add-to-cart-button'])[2]")
        ));
        actions.moveToElement(addToCartButton).click().perform();
        
        Thread.sleep(3000);     

        
        String productPrice = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
        
        System.out.println(productPrice);
        
        driver.quit();
    }
}
