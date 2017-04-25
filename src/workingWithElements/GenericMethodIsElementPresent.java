package workingWithElements;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericmethods.GenericMethods;



public class GenericMethodIsElementPresent {
	
	private WebDriver driver;
	private GenericMethods gm;
	private String baseUrl2 = "http://only-testing-blog.blogspot.com.br/2013/09/testing.html";


	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();
		gm = new GenericMethods(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	public void test() {
		driver.get(baseUrl2);
		System.out.println("Is element present? " + gm.isElementPresent("//div[@id='post-body-7114928646577071695']//input[contains(@name,'vehicle') and contains(@type, 'checkbox')]", "xpath"));
		int size = gm.getListElements("//div[@id='post-body-7114928646577071695']//input[contains(@name,'vehicle') and contains(@type, 'checkbox')]", "xpath").size();
		
		for(int i=0; i<size;i++)
		{
			System.out.println("Testando");
		}
	
	}
	
	@After
	public void tearDown() throws Exception {
	}



}
