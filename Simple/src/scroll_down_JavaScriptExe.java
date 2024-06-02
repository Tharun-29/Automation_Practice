import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class scroll_down_JavaScriptExe {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//Navigate to the Website
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//Enter the Username and Password of the website
		WebElement ele = driver.findElement(By.id("login-button"));
		js.executeScript("arguments[0].click()", ele);
		WebElement scrollelem = driver.findElement(By.className("footer_copy"));
		js.executeScript("arguments[0].scrollIntoView(true);", scrollelem);
	}

}4
