package workingWithElements;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericmethods.GenericMethods;

public class SelectDateCalendar {

	private WebDriver driver;
	private String baseUrl = "https://www.expedia.com.br/";
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@Test
	public void test() throws InterruptedException {
	
		driver.get(baseUrl);
		driver.findElement(By.id("flight-departing")).click();
		WebElement date = driver.findElement
				(By.xpath("//div[@class='datepicker-cal-month'][position()=1]//button[text()='30']"));
		date.click();
		Thread.sleep(3000);
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}


}
