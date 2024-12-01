import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick_prgm {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/context_menu");
		driver.manage().window().maximize();
		//Right Click actions for context menu
		WebElement ele = driver.findElement(By.id("hot-spot"));
        Actions builder = new Actions(driver);
        builder.contextClick(ele).perform();
        //Alert window displayed
        Alert alt = driver.switchTo().alert();
        String out = alt.getText();
        alt.accept();
        System.out.println(out);
        
	}

}
