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

public class GenericMethodExplicitWait {

	
	private WebDriver driver;
	private String baseUrl = "https://letskodeit.teachable.com/p/practice";
	GenericMethods gm = null;
	
	
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
		driver.get(baseUrl);
		WebElement teste = gm.waitForElement(By.id("name"), 3);
		teste.sendKeys("test");
		gm.clickWhenReady(By.id("alertbtn"),3);

	}

	
	@After
	public void tearDown() throws Exception {
	}


}
