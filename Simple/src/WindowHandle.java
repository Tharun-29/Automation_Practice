import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WindowHandle {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.browserstack.com/guide/handle-multiple-windows-in-selenium");
        
		WebElement ele = driver.findElement(By.xpath("//a[text()='Guide']"));
		ele.sendKeys(Keys.CONTROL,Keys.ENTER);
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it = windowHandles.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		driver.switchTo().window(childWindow);
		String text = driver.findElement(By.cssSelector(".display-post__header-description")).getText();
		System.out.println(text);
		
		driver.switchTo().window(parentWindow);
		
		Actions act = new Actions(driver);
		WebElement ele2 = driver.findElement(By.xpath("//li//a//span[text()='Live']"));
		act.scrollToElement(ele2).perform();
		ele2.click();
		
	}

}
