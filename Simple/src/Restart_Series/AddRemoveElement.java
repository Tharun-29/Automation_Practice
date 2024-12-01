package Restart_Series;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddRemoveElement {

	public static void main(String[] args) throws InterruptedException {
		// 1. Navigate to the Internet Herokuapp.com
		// 2. Select and Navigate to Add/Remove Elements
		// 3. Click on Add Elements (Add 10 Element)
		// 4. Delete all the added Elements

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");

		driver.findElement(By.linkText("Add/Remove Elements")).click();
    
		int n = 5;
		for (int i = 1; i <= n; i++) {
			driver.findElement(By.xpath("//button[text()='Add Element']")).click();
		}

		Thread.sleep(2000);

		for (int i = 1; i <= n; i++) {
			driver.findElement(By.xpath("//button[text()='Delete']")).click();
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
