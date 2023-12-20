import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class webTableSortingUsingStreams {

	public static void main(String[] args) {
		/*
		 * Steps - 
		 * 1. Visit the Page - https://rahulshettyacademy.com/seleniumPractise/#/offers
		 * 2. Click on Column
		 * 3. Capture the element for all the first column values
		 * 4. Capture all the text in table into the list
		 * 5. Perform sorting on original list
		 * 6. Compare original and sorted list with Assertion
		 * 		 
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr//th[1]")).click();
		
		
        List<WebElement> elementList = driver.findElements(By.xpath("//tr//th[1]"));

		List<String>  originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		 
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedList));
	}

}
