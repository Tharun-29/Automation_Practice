import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actions_exp_prgm {

	public static void main(String[] args) {
		/* Scenario - 
		 * Launch the URL: https://demo.guru99.com/test/simple_context_menu.html
		 * Perform Right Click operation on the button : right click me
		 * Click on Edit link on the displayed list of right click options
		 * Click on OK button on the alert displayed
		 * Close the browser
		 */
		WebDriver driver = new ChromeDriver();
		
		// Login to Gmail in browser
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.cssSelector(".btn.btn-neutral"));
		Actions builder = new Actions(driver);
		builder.contextClick(ele).perform();
		
		WebElement ele2 = driver.findElement(By.cssSelector(".context-menu-icon.context-menu-icon-edit"));
        builder.click(ele2).perform();
        
        Alert alert = driver.switchTo().alert();
        alert.accept();
	}

}
