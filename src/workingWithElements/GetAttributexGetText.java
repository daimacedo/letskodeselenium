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

public class GetAttributexGetText {
	WebDriver driver;
	String baseUrl = "https://letskodeit.teachable.com/p/practice";


	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.xpath(".//*[@id='radio-btn-example']/fieldset/legend"));
		// Pegar texto presente no elemento
		System.out.println(element.getText());
		WebElement teste = driver.findElement(By.id("openwindow"));
		// pega valor de um atributo do elemento
		String getAttribute = teste.getAttribute("class");
		System.out.println(getAttribute);
		
	}

	@After
	public void tearDown() throws Exception {
	}



}
