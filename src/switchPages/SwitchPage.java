package switchPages;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Set;

public class SwitchPage {
	
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
	
		driver.get(baseUrl);
		String parentHandle = driver.getWindowHandle();
		System.out.println("This is the handle of the 1st page: " + parentHandle);
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();
		
		Set<String> handles = driver.getWindowHandles();
		for(String handle: handles)
		{
			System.out.println("Handles from all pages: " + handle);
			if(!handle.equals(parentHandle))
			{
				driver.switchTo().window(handle);
				WebElement searchBox = driver.findElement(By.id("search-courses"));
				searchBox.sendKeys("Teste");
				Thread.sleep(2000);
				//close just the active window
				driver.close();
				break;
			}
		}
		
		driver.switchTo().window(parentHandle);
		WebElement textname = driver.findElement(By.id("name"));
		textname.sendKeys("Sucess!!");
		
			
		
		
	}


	@After
	public void tearDown() throws Exception {
	}
}
