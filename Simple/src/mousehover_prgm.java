import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mousehover_prgm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.globalsqa.com/demo-site/");
		WebElement ele = driver.findElement(By.id("menu-item-7128"));
		Actions builder = new Actions(driver);
		builder.moveToElement(ele).perform();
		WebElement submenu = driver.findElement(By.id("menu-item-7132"));
		submenu.click();
	}
}
