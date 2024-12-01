import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Adhoc_Practice_1 {

	public static void main(String[] args) {
		// Requirement to open all the links in new tab from footer section and fetch the title of the tab
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//footer section element location
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		List<WebElement> links = footer.findElements(By.tagName("a"));
		int count = links.size();
		System.out.println(count);
		for(int i=0;i<count;i++) {
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			links.get(i).sendKeys(clickOnLinkTab);
		}
		Set<String> windows = driver.getWindowHandles();
		int count2 = windows.size();
		for(String wind:windows) {
			driver.switchTo().window(wind);
			String title = driver.getTitle();
			System.out.println("Window handle Id of the Page ->"+title+"-> is:"+wind);
			driver.close();
		}
		
		/* Alternate Solution
		 * 
		 * Iterator<String> it = windows.iterator();
		 * 
		 * while(it.hasNext())
		 * {
		 * driver.switchTo().window(it.next());
			String title = driver.getTitle();
			System.out.println("Window handle Id of the Page ->"+title+"-> is:"+wind);
			driver.close();
		 * 
		 * */

	}

}
