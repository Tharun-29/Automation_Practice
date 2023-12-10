package E2E_Automation;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2E_Test_2_Genric_approach {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		String[] itemsNeeded = { "Carrot", "Tomato", "Mushroom", "Orange" };

		// Creating methods to handle the search of product and adding to Basket

		addItems(driver, itemsNeeded);

		// Print the Order details in console
		String no_of_items = driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3) strong:nth-child(1)")).getText();
		System.out.println("Number of items:" + no_of_items);

		String price = driver.findElement(By.cssSelector("tbody tr:nth-child(2) td:nth-child(3) strong:nth-child(1)")).getText();
		System.out.println("Price:" + price);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Place')]")).click();

		// Select the country and select the checkbox
		WebElement option = driver.findElement(By.xpath("(//select)[1]"));
		Select dropdown = new Select(option);
		dropdown.selectByValue("Australia");

		// Select the checkbox and submit
		driver.findElement(By.cssSelector("input[type='checkbox'")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();

		// Print the Order confirmation in the console
		System.out.println(driver
				.findElement(By.xpath("//span[contains(text(),'Thank you, your order has been placed successfully')]"))
				.getText());

		Thread.sleep(5000);
		driver.quit();
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		// TODO Auto-generated method stub
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));
		int j = 0;
		for (int i = 0; i < items.size(); i++) {
			String name[] = items.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List<String> itemsNeededLists = Arrays.asList(itemsNeeded);

			if (itemsNeededLists.contains(formattedName)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}
				j++;
			}
		}

	}

}