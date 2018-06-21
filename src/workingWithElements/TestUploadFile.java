package workingWithElements;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestUploadFile {
	
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl = "https://letskodeit.teachable.com/p/practice";
		
	}


	@Test
	public void test() throws InterruptedException {
		
		
		driver.get(baseUrl);
		Thread.sleep(3000);
		WebElement rb1 = driver.findElement(By.id("bmwradio"));
		Thread.sleep(3000);
		rb1.click();
		System.out.println(rb1.isSelected());
		
		WebElement cb2 = driver.findElement(By.id("bmwcheck"));
		cb2.click();
		WebElement cb3 = driver.findElement(By.id("benzcheck"));
		cb3.click();
		
		System.out.println(cb2.isSelected());
		System.out.println(cb3.isSelected());
		
	}



	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}

}
