package Restart_Series;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DropDownPractice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.xpath("//span[@id='ctl00_mainContent_ddl_originStation1_CTXTaction'] /following-sibling::input[@value='Departure City']")).click();
		
		List<WebElement> options = driver.findElements(By.cssSelector("div[id='dropdownGroup1'] div ul  li"));
		
       
		for(WebElement opt: options) {
			 String availableOptions = opt.getText();
			 if(availableOptions.contains("Madurai")) {
				 opt.click();
			 }
		}
		
		List<WebElement> option2 = driver.findElements(By.cssSelector("div[id='dropdownGroup1'] div ul  li"));
		
		for(WebElement opt: option2) {
			 String availableOptions = opt.getText();
			 if(availableOptions.contains("Jaipur")) {
				 opt.click();
			 }
		}
		
		
		
		
	}

}
