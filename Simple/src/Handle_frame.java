import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handle_frame {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		driver.findElement(By.linkText("Frames")).click();
		driver.findElement(By.linkText("iFrame")).click();
		WebElement ele = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(ele);		
		driver.findElement(By.tagName("textarea")).clear();
		driver.findElement(By.tagName("textarea")).sendKeys("Hello Selenium");


	}

}
