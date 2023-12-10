import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class javascript_alert_practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		// Simple Alert
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
        alert.accept();
        
        //Confirmation alert or Pop up
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();	
        
        //Prompt alert or pop up
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert();
        alert.sendKeys("Alert Automation Test");
        alert.accept();
        String result = driver.findElement(By.cssSelector("p[id='result']")).getText();
        System.out.println(result);
        driver.quit();
	}

}
