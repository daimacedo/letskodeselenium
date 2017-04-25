/**
 * 
 */
package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author adtsys
 *
 */
public class ChromeDriverDemo {

	public static void main(String[] args) {
		
		String baseURL = "http://google.com.br";
		
		System.setProperty("webdriver.chrome.driver", "/home/adtsys/selenium_drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(baseURL);
	}

}
