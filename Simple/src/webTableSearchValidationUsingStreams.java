import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class webTableSearchValidationUsingStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 1. Open the WebPage
		 * 2. Search for Item in Table
		 * 3. Validate the Results present in the table
		 */
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
         driver.findElement(By.id("search-field")).sendKeys("Beans");
         
         //Collect the Item list present in table for Validation
         List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
         List<WebElement> itemsList = items.stream().filter(veggie->veggie.getText().contains("Beans")).collect(Collectors.toList());
         
         //performing validation by comparing the size of both list i.e items (Items displayed in table) and itemsList(Searched item displayed in table)
         Assert.assertEquals(items, itemsList);
         
         
	}

}
