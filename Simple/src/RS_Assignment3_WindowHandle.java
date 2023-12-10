import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RS_Assignment3_WindowHandle {

	public static void main(String[] args) {
		/*
		 * Test Case Steps - 1. Open the page - https://the-internet.herokuapp.com/ 2.
		 * Click on Multiple window link 3. Click on Click Here link to open new page in
		 * new window 4. Get all the window handles 5. Switch to Child Window 6. Fetch
		 * the value displayed and print in the console 7. Switch to Parent window 8.
		 * Fetch the value displayed and print in the console
		 */

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		// Collecting all the window handle open in browser
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWind = it.next();
		String childWind = it.next();
		driver.switchTo().window(childWind);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.switchTo().window(parentWind);
		System.out.println(driver.findElement(By.tagName("h3")).getText());
		driver.quit();
	}

}
