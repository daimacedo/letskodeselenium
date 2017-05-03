package workingWithElements;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalendarList {
	
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
		WebElement textDate = driver.findElement(By.id("flight-departing"));
		textDate.click();
		WebElement element = driver.findElement(By.xpath("//div[@class='datepicker-cal-month'][1]//tbody[@class='datepicker-cal-dates']"));
		List<WebElement> listElement = element.findElements(By.tagName("button"));

		for(WebElement teste: listElement)
		{
			if(teste.getText().equals("25"))
			{
				teste.click();	
				System.out.println("foi ein?!");
				break;
			}
		}
	}
	
	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(3000);
		driver.quit();
		
	}

}
