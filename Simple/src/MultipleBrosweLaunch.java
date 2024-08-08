import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MultipleBrosweLaunch {

	public static void main(String[] args) throws InterruptedException {
		
		/* Scenario 1- 
		 *  GC browser in normal mode - amazon.com - get title() - copy
		 *  GC broswer in incognito mode - amazon.com - paste - textbox - close
		 * 
		 */
		
		 WebDriver driver1 = new ChromeDriver();
		 driver1.get("https://www.amazon.in/");
		 String url = driver1.getCurrentUrl();
		 
		 
		  
		 ChromeOptions opt = new ChromeOptions();
		 opt.addArguments("--incognito");
		 WebDriver driver2 = new ChromeDriver(opt);
		 driver2.get(url);
		 Thread.sleep(3000);
		 driver2.close();
		
		
		

	}

}
