import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLinks {

	public static void main(String[] args) throws IOException {
		/*
		 * How to Find Broken Links / Automate Broken Links Steps - 1. Get all the
		 * URL's/link in the Page using Selenium 2. Using Java Method - Will be Passing
		 * the URL to Java methods get the status code 3. If Status Code received is >
		 * 400 -> then that URL is not working -> Link which tied to URL is Broken
		 *
		 */
		
		// Blog about Broken Links - https://medium.com/@amaralisa321/how-to-find-broken-links-using-selenium-webdriver-6e0707bc6016
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> urls = driver.findElements(By.tagName("a"));
		for(WebElement url: urls) {
			String urlLink = url.getAttribute("href");
			verifyLink(urlLink);
		}
		driver.quit();
	}

	public static void verifyLink(String urlLink) throws IOException {
		try {
		
		URL link = new URL(urlLink);
		HttpURLConnection httpURLConn = (HttpURLConnection) link.openConnection();
		httpURLConn.setConnectTimeout(3000);
		httpURLConn.connect();
		
		
		if(httpURLConn.getResponseCode()==200) {
			System.out.println(urlLink+" - "+httpURLConn.getResponseMessage());
		}else {
			System.out.println(urlLink+" - "+httpURLConn.getResponseMessage()+" - " + "is a broken link");
		}
		}catch (Exception e) {
			System.out.println(urlLink+" - " + "is a broken link");
		}
		
		
	}

}
