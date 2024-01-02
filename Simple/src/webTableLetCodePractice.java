import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webTableLetCodePractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/table");
		List<WebElement> names = driver.findElements(By.xpath("//table[@id='simpletable']//tr//td[1]"));
		List<String> nameList = names.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> key = nameList.stream().filter(p->p.contains("iron")).collect(Collectors.toList());
		

	}

}
