package E2E_Automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UploadDownload {

	public static void main(String[] args) {
		
		String fileName = "C:/Users/THVS0621/Downloads/download.xlsx";
	   
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		
		//download
		driver.findElement(By.id("downloadButton")).click();
		
		//Edit Excel - get ColumnNumber of price - get RowNumber of Apple -> update excel with row,col
		int col = getColumnNumber(fileName,"price");
		//int row = getRowNumber(fileName,"Apple");
		//updateCell(fileName,row,col);
		
		
		
		//upload
		driver.findElement(By.id("fileinput")).sendKeys("C:/Users/THVS0621/Downloads/download.xlsx");
		
		//wait for success message to show up and wait for disappear
		
		WebElement success_message = driver.findElement(By.xpath("//div[@class=\"Toastify__toast-body\"]//div[2]"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(success_message));
		String toastText = success_message.getText();
		Assert.assertEquals(toastText, "Updated Excel Data Successfully.");
		System.out.println(toastText);
		wait.until(ExpectedConditions.invisibilityOf(success_message));
		
		//verify updated excel data showing in the web table
		String priceColumn = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");
		String actualPrice = driver.findElement(By.xpath("//div[text()='Apple']/../..//div[@id='cell-"+priceColumn+"-undefined']")).getText();
		System.out.println(actualPrice);
		Assert.assertEquals("390", actualPrice);

	}

	private static int getColumnNumber(String fileName, String string) {
		// TODO Auto-generated method stub
		return 0;
	}

}
