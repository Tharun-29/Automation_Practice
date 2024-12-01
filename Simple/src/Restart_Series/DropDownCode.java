package Restart_Series;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownCode {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
        dropdown.click();
        dropdown.sendKeys(Keys.ARROW_DOWN);
        dropdown.sendKeys(Keys.ARROW_DOWN);
        dropdown.sendKeys(Keys.ARROW_DOWN);
        dropdown.sendKeys(Keys.ENTER);
        
		
	} 

}
