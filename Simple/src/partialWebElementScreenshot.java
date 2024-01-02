import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class partialWebElementScreenshot {

	public static void main(String[] args) throws IOException {
		/*
		 * Scenario - 
		 * 1. Navigate to https://rahulshettyacademy.com/angularpractice/
		 * 2. Fill the name Field with the first course name available at - 
		 * https://rahulshettyacademy.com/
		 * 3. Taking WebElement Partial Screenshot
		 */
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://rahulshettyacademy.com/angularpractice/");
      String parentWindow = driver.getWindowHandle();
      
      //Switching to new tab in same window and entering new URL Website
      driver.switchTo().newWindow(WindowType.TAB).get("https://rahulshettyacademy.com/");
      WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'25+ Courses')]"));
      Actions acti = new Actions(driver);
      acti.scrollToElement(ele);
      String name = ele.getText();
      driver.switchTo().window(parentWindow);
      WebElement nameBox = driver.findElement(By.xpath("//input[@name='name']"));
      nameBox.sendKeys(name);
      File file = nameBox.getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(file, new File("Logo1.png"));
      driver.quit();

	}

}
