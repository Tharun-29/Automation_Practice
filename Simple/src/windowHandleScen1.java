
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandleScen1{

	public static void main(String[] args){
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		// Clicking on the link in page - which opens another page in new tab in browser
		driver.findElement(By.cssSelector("a.blinkingText")).click();
		// Now we need to switch the driver control to new tab to operate selenium
		// actions/work in new page or else exception will be thrown
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentWindo = it.next();
		String childWindo = it.next();
		driver.switchTo().window(childWindo);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		//Using Debugger in Eclipse - Tried to find below the string value
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		//switch back to parent window
		driver.switchTo().window(parentWindo);
		driver.findElement(By.cssSelector("#username")).sendKeys(emailId);
	}

}
