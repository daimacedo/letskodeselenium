package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxDriverDemo {

	public static void main(String[] args) {
		
		
		// set property just for the 3.x webdriver
		// I need the gecko driver to it works
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		String baseURL = "http://www.google.com";
		driver.get(baseURL);
	
		

	}

}
