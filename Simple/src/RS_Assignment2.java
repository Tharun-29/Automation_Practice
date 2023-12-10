import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RS_Assignment2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Enter the Name
		driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']")).sendKeys("Victor");
		//Enter the Email
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("Victor2023@gmail.com");
        //Enter the password
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Victor2023");
        //Select the checkbox
        driver.findElement(By.id("exampleCheck1")).click();
        //Select the Radiobutton
        driver.findElement(By.id("inlineRadio1")).click();
        //Enter the DOB
        driver.findElement(By.cssSelector("input[name='bday']")).sendKeys("02/01/2000");
        //Click the Submit Button
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        System.out.println(driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText());
      /* String output = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
        String[] results = output.split("x");
        for(String out: results) {
        	System.out.println(out);
        } */
        //Close the browser
        driver.quit();
	}

}
