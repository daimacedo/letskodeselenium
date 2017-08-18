package basicweb;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverDemo {

	@Test
	public void teste() {
			
		// set property just for the 3.x webdriver
		// I need the gecko driver to it works
		System.setProperty("webdriver.gecko.driver", "/home/daiane.macedo/Desktop/Daiane/seleniumDrivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		String baseURL = "http://www.uol.com.br";
		driver.get(baseURL);
	
	
		

	}

}
