


// How to retrieve color of elements in automation? Write Code?
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class elementColor_script {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		String button_color = driver.findElement(By.id("login-button")).getCssValue("background-color");
        System.out.println(button_color);
        String hex_button_color = Color.fromString(button_color).asHex();
        System.out.println(hex_button_color);
	}

}
