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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.jna.platform.win32.Netapi32Util.User;

public class ExplicitWait {

	// I have to use explicit wait just when the element is very slow, in all the other
	//cases i should use implicit waits. Ajax for example is a good way to use explicit
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		
		driver.get(baseUrl);
		// timeout case the element is not find
		WebDriverWait wait = new WebDriverWait(driver, 5);
		//1st way
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
		//2nd way
		WebElement element = driver.findElement(By.id("name"));
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys("Testes");
		
	}
	
	@After
	public void tearDown() throws Exception {
	}




}
