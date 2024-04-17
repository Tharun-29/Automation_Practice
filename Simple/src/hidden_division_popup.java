import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class hidden_division_popup {

	public static void main(String[] args) {
		// To handle notification in ChromeBrowser
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-geolocations");
		options.addArguments("--ignore-certificate-errors");
		WebDriver driver = new ChromeDriver(options);
		driver.get(" https://www.easemytrip.com/?msclkid=6b6f8f6d183c1c4cd628eb913a898429&utm_source=bing&utm_medium=cpc&utm_campaign=Competitors%20RLSA&utm_term=clear%20trip%20com&utm_content=Competitors%20PM");
	}

}
