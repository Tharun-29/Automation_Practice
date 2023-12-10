import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class dropdownByClick_pract {

	public static void main(String[] args) throws InterruptedException {
		//Take input from user for number of children's and Infants 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of times option to be selected");
		int n = sc.nextInt();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("divpaxinfo")).click();
		for(int i=0;i<n;i++) {
	    driver.findElement(By.id("hrefIncInf")).click();
		driver.findElement(By.id("hrefIncChd")).click();
		Thread.sleep(2000);
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		Thread.sleep(2000);
		driver.quit();
	}

}
