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

public class MultipleSelect {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void test() throws InterruptedException {
		
		WebElement element = driver.findElement(By.id("multiple-select-example"));
		Select sel = new Select(element);

		
		sel.selectByValue("orange");
		Thread.sleep(2000);
		
		sel.deselectByValue("orange");
		Thread.sleep(2000);
		
		sel.selectByIndex(2);
		Thread.sleep(2000);
		
		sel.selectByVisibleText("Apple");
		Thread.sleep(2000);
		
		sel.selectByIndex(0);
		Thread.sleep(2000);
		
		List<WebElement> list = sel.getAllSelectedOptions();
		int size = list.size();
		
		for(int i =0; i<size; i++)
		{
			System.out.println(list.get(i).getText());
		}
		
		sel.deselectAll();
		Thread.sleep(2000);
		
				
	}
	
	
	@After
	public void tearDown() throws Exception {
		
		driver.close();
	}



}
