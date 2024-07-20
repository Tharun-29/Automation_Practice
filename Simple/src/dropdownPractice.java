import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdownPractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//driver.findElement(By.id("login-button")).click();
		
		// Selecting the value or option from dropdown
		//WebElement ele = driver.findElement(By.className("product_sort_container"));
        //Select opt = new Select(ele);
        //opt.selectByValue("lohi");
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.switchTo().frame("frame-one796456169");
        WebElement ele1 = driver.findElement(By.xpath("//select[@class='drop_down']"));
        ele1.click();
        Select opt1 = new Select(ele1);
        opt1.selectByValue("Radio-0");
        WebElement out =  opt1.getFirstSelectedOption();
        String output = out.getText();
        System.out.println(output);
	}

}
