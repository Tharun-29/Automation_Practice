import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class dynamicDropdown_pract {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[text()='From']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='BLR']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[text()='DEL']")).click();
		Thread.sleep(5000);
		driver.quit();

	}

}
