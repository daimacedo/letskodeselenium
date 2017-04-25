package workingWithElements;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class List2 {

	WebDriver driver;
	String baseUrl = "http://only-testing-blog.blogspot.com.br/2013/09/testing.html";
	String baseUrl2 = "";
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		
	}


	@Test
	public void test() throws InterruptedException {
		boolean ischecked = false;
		java.util.List<WebElement> lista = driver.findElements
				(By.xpath("//div[@id='post-body-7114928646577071695']//input[contains(@name,'vehicle') and contains(@type, 'checkbox')]"));
		int size = lista.size();
		System.out.println("Size of the list: " + size);
			for(int i=0; i<size; i++){
				System.out.println("testando");
			ischecked = lista.get(i).isSelected();
			if (ischecked!=true)
			{
				lista.get(i).click();
				Thread.sleep(2000);
				System.out.println("checkbox number: " + i + " selected");
			}
			
		}
		System.out.println("All checkboxes checkeds");
		
	}

	
	@After
	public void tearDown() throws Exception {
	}

}
