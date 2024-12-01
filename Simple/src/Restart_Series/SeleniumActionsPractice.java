package Restart_Series;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActionsPractice {

	private static WebElement button;

	public static void main(String[] args) {
		/* Scenario - 
		 * Launch the URL: https://demo.guru99.com/test/simple_context_menu.html
		 * Perform Right Click operation on the button : right click me
		 * Click on Edit link on the displayed list of right click options
		 * Click on OK button on the alert displayed
		 * Close the browser
		 */
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		
		Actions builder = new Actions(driver);
		button = driver.findElement(By.xpath("//span[text()='right click me']"));
		builder.contextClick(button);
		builder.perform();
		
		
		driver.findElement(By.xpath("//span[text()='Edit']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.close();
	}

}
