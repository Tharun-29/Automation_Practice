import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class file_upload_popup {

	public static void main(String[] args) {
		// To Handle File Upload using send keys method (Note - We can use Sendkeys method only if the upload or choose file button type is "File" in DOM)
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("File Upload")).click();
		driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\THVS0621\\Downloads\\test-clip-art-cpa-school-test.png");

	}

}
