import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;


public class mousehover_prgm {

	public static void main(String[] args) {
		
		//Adding the Below code to disable or block Ad pop ups
		
		ChromeOptions options  = new ChromeOptions();
	    //options.addArguments("incognito");
	    options.addArguments("--disable-popup-blocking");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	  
	
		WebDriver driver = new ChromeDriver(options);
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
