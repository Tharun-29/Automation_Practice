import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RS_Assignment4_Frame {

	public static void main(String[] args) {
		/* 
		 Test Steps - 
		 1. Open the https://the-internet.herokuapp.com/ website
		 2. Click on Nested frame link
		 4. Switch to Top Frame section in the page
		 3. Switch to Middle Text Frame
		 4. Fetch the value displayed on screen and print in console
		 */
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.linkText("Nested Frames")).click();
		
		//using index to switch to top frame
		driver.switchTo().frame(0);
		
		//using Webelement to switch to middle frame
		WebElement ele =  driver.findElement(By.cssSelector("[name='frame-middle']"));
		driver.switchTo().frame(ele);
		String text = driver.findElement(By.id("content")).getText();
		System.out.println(text);

	}

}
