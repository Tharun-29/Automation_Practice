import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableScript {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://letcode.in/table");
		
		List<WebElement> List = driver.findElements(By.xpath("//table[@id='shopping']//tr/td[1]"));
		
		List<WebElement> priceList = driver.findElements(By.xpath("//table[@id='shopping']//tr/td[2]"));
		
		for(WebElement items: List) {
		   System.out.println(items.getText());
		}
        
		int sum =0;
		for(WebElement price: priceList) {
			
		 sum += Integer.parseInt(price.getText());
		}
		System.out.println(sum);
		int total = 858;
		assertEquals(sum, total);
	}

}
