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
import org.openqa.selenium.support.ui.Select;


public class DropDownAndMultiSelectors {
	
	WebDriver driver;
	String baseUrl = "http://only-testing-blog.blogspot.com.br/2013/09/testing.html";
	String baseUrl2 = "http://expedia.com.br";

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	

	@Test
	public void testMultiSelector() throws InterruptedException {

	 	driver.get(baseUrl);
		Select sel1 = new Select(driver.findElement(By.name("FromLB")));
				
		//save a select into a list
		List<WebElement> lista = sel1.getOptions();
		int size = lista.size();
		
		for(int i=0; i<size; i++)
		{
			String optionName = lista.get(i).getText();
			System.out.println(optionName);
		}
		
		
		sel1.selectByValue("Russia");
		Thread.sleep(5000);
		sel1.selectByValue("Japan");
		Thread.sleep(5000);
		
		sel1.deselectByIndex(1);
		Thread.sleep(5000);
		sel1.selectByValue("Russia");
		Thread.sleep(5000);
		
		sel1.deselectAll();
		Thread.sleep(5000);
	}

	@Test
	public void testDropDown() throws InterruptedException {
		driver.get(baseUrl2);
		Select sel2 = new Select(driver.findElement(By.id("flight-adults")));
		sel2.selectByValue("4");
		Thread.sleep(1000);
		
	}

	@After
	public void tearDown() throws Exception {
		
		Thread.sleep(5000);
	}
}
