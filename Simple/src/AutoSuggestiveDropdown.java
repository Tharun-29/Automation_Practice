import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		//CSS Selector and FindElements used - to fetch all the values in the option
		List<WebElement> options = driver.findElements(By.cssSelector("li.ui-menu-item a"));
        for(WebElement option : options) {
        	System.out.println(option.getText());
        	if(option.getText().equalsIgnoreCase("India"))
        	{
        		option.click();
        	}
        }
        Thread.sleep(3000);
        driver.quit();
        
	}

}
