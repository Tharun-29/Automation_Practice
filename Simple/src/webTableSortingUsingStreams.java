import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class webTableSortingUsingStreams {

	public static void main(String[] args) {
		/*
		 * Steps - 1. Visit the Page -
		 * https://rahulshettyacademy.com/seleniumPractise/#/offers 2. Click on Column
		 * 3. Capture the element for all the first column values 4. Capture all the
		 * text in table into the list 5. Perform sorting on original list 6. Compare
		 * original and sorted list with Assertion
		 * 
		 */

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.xpath("//tr//th[1]")).click();

		// Capture the text of all the Webelements into new(Original List)
		List<WebElement> elementList = driver.findElements(By.xpath("//tr//td[1]"));

		List<String> originalList = elementList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Sort on originalList of step 3 -> Sorted List

		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// Compare Original List vs Sorted List
		Assert.assertTrue(originalList.equals(sortedList));

		// scan the name column with getText -> Rice -> Print the price of the Rice

		// Pagination Concept - Try to implement script to Find the Price of Items
		// present in different Page

		List<String> price;
		do {

			List<WebElement> rows = driver.findElements(By.xpath("//tr//td[1]"));

			price = rows.stream().filter(p -> p.getText().contains("Strawberry")).map(p -> getVeggiePrice(p))
					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));
			if (price.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Last']")).click();
			}
		} while (price.size() < 1);

	}

	private static String getVeggiePrice(WebElement p) {
		String priceValue = p.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
