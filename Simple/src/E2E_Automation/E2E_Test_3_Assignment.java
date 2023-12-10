package E2E_Automation;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E2E_Test_3_Assignment {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * 1. Open the Website - https://rahulshettyacademy.com/loginpagePractise/ 2.
		 * Enter Username, Password 3. Select User Radiobutton 4. Select Student from
		 * the dropdown 5. Select the Checkbox 6. Click on Sign In
		 */

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.cssSelector("input#username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input#password")).sendKeys("learning");
		driver.findElement(By.cssSelector("input[value='user']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#okayBtn")));
		driver.findElement(By.cssSelector("button#okayBtn")).click();
		WebElement ele = driver.findElement(By.cssSelector("select.form-control"));
		Select dropdwn = new Select(ele);
		dropdwn.selectByValue("consult");
		driver.findElement(By.cssSelector("input#terms")).click();

		driver.findElement(By.cssSelector("input#signInBtn")).click();
		wait.until(ExpectedConditions.titleIs("ProtoCommerce"));

		String phoneNeeded[] = { "iphone X", "Nokia Edge", "Blackberry" };
		addproducts(driver, phoneNeeded);

	}

	public static void addproducts(WebDriver driver, String[] phoneNeeded) {
		List<WebElement> productAvailable = driver.findElements(By.xpath("//h4[@class='card-title']//a"));
		int j = 0;
		for (int i = 0; i < productAvailable.size(); i++) {
			String name = productAvailable.get(i).getText().trim();
			System.out.println(name);
			List<String> products = Arrays.asList(phoneNeeded);
			if (products.contains(name)) {
				driver.findElements(By.xpath("//button[text()='Add ']")).get(i).click();
				j++;
			}
			if (j == phoneNeeded.length) {
				break;
			}
		}

	}

}
