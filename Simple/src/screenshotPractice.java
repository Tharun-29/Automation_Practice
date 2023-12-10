import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class screenshotPractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshots/img.png");
		FileHandler.copy(src, dest);
		driver.findElement(By.id("login-button")).click();
		WebElement ele = driver.findElement(By.xpath("//a/img[@alt='Sauce Labs Backpack']"));
		File newSrc = ele.getScreenshotAs(OutputType.FILE);
		File newDest = new File("./Screenshots/img2.png");
		FileHandler.copy(newSrc, newDest);
		driver.quit();

	}

}
