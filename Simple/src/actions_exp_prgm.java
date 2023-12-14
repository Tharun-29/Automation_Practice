import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actions_exp_prgm {

	public static void main(String[] args) {
		/* Scenario - 
		 * 1. Login to Gmail
		 * 2. Based on the subject of a mail, Right click on the mail
		 * 3. Select the archive option
		 */
		
		WebDriver driver = new ChromeDriver();
		// Login to Gmail in browser
		driver.get("https://mail.google.com/mail/u/0/#inbox");
		WebElement ele = driver.findElement(By.xpath("//tr[@id=':1p']"));
		String out = ele.getText();
		Actions builder = new Actions(driver);
		builder.contextClick().perform();

	}

}
