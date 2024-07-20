import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RS_Assignment3 {

public static void main(String[] args) {
		// Steps

		/*
		 * 1. Select any checkbox 
		 * 2. Grab the Label of the Selected Checkbox 
		 * 3. Select an Option in dropdown. Here option to select should come from Step2 
		 * 4. Enter Step 2 Grabbed label text in Editbox 
		 * 5. Click Alert and then Verify if text grabbed from Step 2 is present in the pop up message
		 */
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.xpath("//label/input[@type='checkbox']")).click();
		String Value = driver.findElement(By.xpath("//label/input[@type='checkbox']")).getAttribute("value");

		WebElement selec = driver.findElement(By.cssSelector("#dropdown-class-example"));
		Select select = new Select(selec);
		select.selectByValue(Value);

		driver.findElement(By.id("name")).sendKeys(Value);

		driver.findElement(By.id("alertbtn")).click();
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		System.out.println(message);
		alert.accept();
		
		/*
		 * List<WebElement> ele =
		 * driver.findElements(By.xpath("//label/input[@type='checkbox']"));
		 * List<String> opt = new ArrayList(); for(int i=0;i<ele.size();i++) {
		 * opt.add(ele.get(i).getAttribute("value")); } for(String option:opt){
		 * System.out.println(option); 
		 * }
		 */
		
	}

}