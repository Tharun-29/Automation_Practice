package Interview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWindowPopUp {

    public static void main(String[] args) {
        /*
         * Handling Window Authentication Pop up
         * This is typically used for basic authentication where a browser pop-up
         * requires a username and password. The format is:
         * http://Username:Password@SiteURL
         */

        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize a new ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // URL with embedded username and password for basic authentication
        String url = "https://admin:admin@the-internet.herokuapp.com/";

        // Open the URL
        driver.get(url);

        // Locate and click the "Basic Auth" link on the webpage
        driver.findElement(By.xpath("//a[contains(text(),'Basic Auth')]")).click();

        // Close the browser
        driver.quit();
    }
}
