import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class RS_Assignment6_Auto_Sug_DropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("An");
		String ER_Text = "Antarctica";
		List<WebElement> options = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
		Actions act = new Actions(driver);
		for (WebElement opt : options) {
			if (ER_Text.equalsIgnoreCase(opt.getText())) {
				act.moveToElement(opt).click().perform();
			}
		}
		driver.quit();
	}

}
