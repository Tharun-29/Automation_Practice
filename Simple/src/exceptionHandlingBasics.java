import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class exceptionHandlingBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      WebDriver driver = new ChromeDriver();
      driver.get("https://rahulshettyacademy.com/angularpractice/");
      //Using Try-Catch Exception to handle below NoSuchElementException
      try {
    	  WebElement ele = driver.findElement(By.cssSelector("Test"));
    	  ele.click();
	} catch (NoSuchElementException e) {
		System.out.println("Handled");
	}
      
	}

}
