package workingWithElements;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestJunit {
	
	WebDriver driver;
	String baseURL;
	
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		baseURL = "https://letskodeit.teachable.com";
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	
	@Test
	public void test() {
			
		driver.get(baseURL);
		driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']")).click();
		System.out.println("Cliquei em login");
		driver.findElement(By.id("user_email")).clear();
		System.out.println("limpei o usuario");
		driver.findElement(By.id("user_password")).clear();
		System.out.println("Limpei a senha");
		driver.findElement(By.id("user_email")).sendKeys("teste@teste");
		System.out.println("Enviei o usuario");
		driver.findElement(By.id("user_password")).sendKeys("teste");
		System.out.println("Enviei a senha");
		
	}


	@After
	public void tearDown() throws Exception {
		driver.quit();
	}


}
