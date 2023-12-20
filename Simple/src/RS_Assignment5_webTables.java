import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RS_Assignment5_webTables {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Scenarios - 
		 * 1. Print the Number of rows in the table 
		 * 2. Print the Number of Columns in the table 
		 * 3. Print the second row output in console
		 * 
		 */
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,300)");

		// 1.Print the Number of rows in the table 
		int no_of_rows = driver.findElements(By.cssSelector(".table-display tr")).size();
		System.out.println(no_of_rows);

		// 2.Print the Number of Columns in the table 
		int no_of_col = driver.findElements(By.cssSelector(".table-display th")).size();
		System.out.println(no_of_col);

		// 3.Print the second row output in console
		List<WebElement> values = driver.findElements(By.xpath("//table[@class='table-display']//tr[2]/td"));
		String output = "";
		for (WebElement val : values) {
			String fetchedValue = val.getText();
			System.out.print(fetchedValue + " ");

		}
		System.out.println(output);
	}
}
