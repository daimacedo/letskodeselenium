package basicweb;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilitiesDemo {

	public static void main(String[] args) {
		
		// I use desired Capabilities to set some configurations do my test execution
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		String baseURL = "https://letskodeit.teachable.com/p/practice";
		
		// set the browser
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		// set the browser name
		caps.setBrowserName("firefox");
		// set the OS
		caps.setPlatform(Platform.LINUX);
		driver.get(baseURL);
 
	}

}
