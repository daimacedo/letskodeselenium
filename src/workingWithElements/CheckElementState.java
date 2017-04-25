package workingWithElements;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckElementState {
	
	WebDriver driver;
	String baseUrl;
	

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl = "http://www.google.com.br";
		
	}



	@Test
	public void test() {
		
		driver.get(baseUrl);
		WebElement e1 = driver.findElement(By.id("gs_htif0"));
		System.out.println("Element is enable? " + e1.isEnabled());
		
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
