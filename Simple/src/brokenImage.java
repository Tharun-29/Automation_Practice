import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenImage {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/broken_images");
		List<WebElement> imgInfo = driver.findElements(By.xpath("//div[@id='content']//img"));

		for (WebElement ele : imgInfo) {
			String imgSrc = ele.getAttribute("src");
			verify(imgSrc);
		}

	}

	private static void verify(String imgSrc) throws IOException {
		
		try {
		URL img = new URL(imgSrc);
		HttpURLConnection con = (HttpURLConnection) img.openConnection();
		con.setConnectTimeout(3000);
		con.connect();
		
		int responseCode = con.getResponseCode();
        if(responseCode>400) {
        	System.out.println("Broken Images: "+imgSrc);
        }else {
        	System.out.println("Valid Images: "+imgSrc);
        }
		
	}catch(Exception e) {
		System.out.println("Error Checking image:" +imgSrc+"Exception:"+e.getMessage());
	}

}
}

