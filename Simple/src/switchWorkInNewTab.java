import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class switchWorkInNewTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Logic or method used to Switch to New Window or tab in browser
		// Selenium 4 Open, Switch & Work In New Tab
		driver.switchTo().newWindow(WindowType.TAB).get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

	}

}
