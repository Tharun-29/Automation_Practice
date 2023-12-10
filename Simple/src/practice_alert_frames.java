import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice_alert_frames {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//alerts or pop up
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Batman");
		alert.accept();
		String out = driver.findElement(By.id("demo")).getText();
		System.out.println(out);
	}	
}
