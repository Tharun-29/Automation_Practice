import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class sslCertificationPageAutomate {

	public static void main(String[] args) {
		
		//Chrome Browser
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		//Firefox Browser
		FirefoxOptions opt1 = new FirefoxOptions();
		opt1.setAcceptInsecureCerts(true);
		WebDriver driver1 = new FirefoxDriver(opt1);
		driver1.get("https://expired.badssl.com/");
		System.out.println("URL fetched from firefox "+driver1.getCurrentUrl());
		
		//Edge Browser
		EdgeOptions edge = new EdgeOptions();
		edge.setAcceptInsecureCerts(true);
		EdgeDriver driver2 = new EdgeDriver(edge);
		driver2.get("https://expired.badssl.com/");
		System.out.println(driver2.getPageSource());
		
	}

}
