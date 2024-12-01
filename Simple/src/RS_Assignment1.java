

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class RS_Assignment1 {

	public static void main(String[] args) {
		/*
		 * Questions for this assignment
		 * https://rahulshettyacademy.com/AutomationPractice/

           Check the first  Checkbox and verify if it is successfully checked and Uncheck it again to verify if it is successfully Unchecked
           How to get the Count of number of check boxes present in the page
		 */
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.id("checkBoxOption1")).click();
		//org.testng.Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		driver.findElement(By.id("checkBoxOption1")).click();
		//org.testng.Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
		org.testng.Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected(), "Test Case Failed");
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	}

}	
