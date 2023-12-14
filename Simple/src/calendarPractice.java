import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class calendarPractice {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		// wait.until(ExpectedConditions.elementToBeSelected(By.cssSelector("#form-field-travel_comp_date")));
		// Clicking on Calendar Icon
		WebElement ele = driver.findElement(By.xpath("//input[@id='form-field-travel_comp_date']"));
		int p1 = ele.getLocation().getX();
		int p2 = ele.getLocation().getY();
		Actions act = new Actions(driver);
		act.scrollByAmount(p1, p2).perform();
		ele.click();
		
		// day
		List<WebElement> day = driver.findElements(By.cssSelector(".flatpickr-day "));
		for (int i = 0; i < day.size(); i++) {
			String dayNo = day.get(i).getText();
			if (dayNo.equalsIgnoreCase("28")) {
				day.get(i).click();
			}
		}
	}
}
