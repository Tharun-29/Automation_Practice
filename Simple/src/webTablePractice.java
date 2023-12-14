import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class webTablePractice {

	public static void main(String[] args) {
		/*
		 * Test Case - 1. Open the Webpage -
		 * https://rahulshettyacademy.com/AutomationPractice/ 2. Sroll the page till the
		 * table section displayed 3. Now try to Scroll the table and collect all the
		 * Values to Sum 4. Use Assertion from TestNG to Compare the ER and AR Test
		 * Results
		 */
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Test Step2
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");

		// Test Step3
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));

		int sum = 0;
		for (int i = 0; i < values.size(); i++) {
			int num = Integer.parseInt(values.get(i).getText());
			sum = sum + num;
		}
		System.out.println(sum);

		// Test Step 4

		int ER_Sum = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, ER_Sum);
	}

}
