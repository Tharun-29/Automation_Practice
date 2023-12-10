package E2E_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class E2E_Test_1 {


	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		/* Test Steps
		 * 1.open the website or application - https://rahulshettyacademy.com/seleniumPractise/#/
		 * 2. Add any 1 Vegetables to basket (Qty - 3)
		 * 3. Add any 1 fruits to basket (Qty - 2)
		 * 4. Add Mushroom by searching in search box and add to basket
		 * 5. Select the Basket
		 * 6. Print the Order details in console
		 * 7. Proceed checkout
		 * 8. Select the country and select the checkbox
		 * 9. Click Continue
		 * 10. Print the Order confirmation in the console or use the assertions
		 */
	     
		//2. Add any 1 Vegetables to basket (Qty - 3)
		driver.findElement(By.xpath("//div[@class='products']//div[1]//div[2]//a[2]")).click();
		driver.findElement(By.xpath("//div[@class='products']//div[1]//div[3]//button[1]")).click();
		driver.findElement(By.xpath("//div[@class='products']//div[1]//div[2]//a[2]")).click();
		driver.findElement(By.xpath("//div[4]//div[3]//button[1]")).click();
		
		Thread.sleep(3000);
		
		/*
		 * WebElement locate = driver.findElement(By.xpath("//div[18]//p[1]")); int x =
		 * locate.getLocation().getX(); int y = locate.getLocation().getY();
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy("+x+","+y+")");
		 * 
		 * Thread.sleep(3000);
		 */
		//3. Add any 2 fruits to basket (Qty - 2)
		driver.findElement(By.xpath("//div[18]//div[2]//a[2]")).click();
		driver.findElement(By.xpath("//div[18]//div[3]//button[1]")).click();
		driver.findElement(By.xpath("//div[20]//div[2]//a[2]")).click();
		driver.findElement(By.xpath("//div[20]//div[3]//button[1]")).click();
		
		//4. Add Mushroom by searching in search box and add to basket
		driver.findElement(By.cssSelector("input[type=search]")).sendKeys("mushroom");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		//select the qty
		Thread.sleep(2000);
		driver.findElement(By.linkText("+")).click();
		driver.findElement(By.xpath("//button[contains(text(),'ADD TO')]")).click();
		
		
		//Print the Order details in console
		String no_of_items = driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) strong:nth-child(1)")).getText();
		System.out.println("Number of items:"+no_of_items);
		
		String price = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(3) strong:nth-child(1)")).getText();
		System.out.println("Price:"+price);
		
		// Proceed checkout
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Place')]")).click();
		
		//Select the country and select the checkbox
		WebElement option = driver.findElement(By.xpath("(//select)[1]"));
		Select dropdown = new Select(option);
		dropdown.selectByValue("Australia");
		
		//Select the checkbox and submit
		driver.findElement(By.cssSelector("input[type='checkbox'")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
		//Print the Order confirmation in the console
		System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Thank you, your order has been placed successfully')]")).getText());
		
		Thread.sleep(5000);
		driver.quit();
	}
}
