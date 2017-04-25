package workingWithElements;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicTreeUI.TreeHomeAction;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigatingBetweenPages {
	
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "http://www.software-testing-tutorials-automation.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@Test 
	public void test() throws InterruptedException {
		
		
		driver.get(baseUrl);
		String title = driver.getTitle();
		String currentPage = driver.getCurrentUrl();
		Thread.sleep(2000);
		System.out.println("The tittle of the page is: " + title);
		System.out.println("The current page is: " + currentPage);
		
		
		Thread.sleep(2000);
		String navigateTo = "http://www.software-testing-tutorials-automation.com/p/selenium-webdriver.html";
		driver.navigate().to(navigateTo);
		currentPage = driver.getCurrentUrl();
		System.out.println("The current page is: " + currentPage);
		
		Thread.sleep(2000);
		driver.navigate().back();
		currentPage = driver.getCurrentUrl();
		System.out.println("The current page is: " + currentPage);
		
		Thread.sleep(2000);
		driver.navigate().forward();
		currentPage = driver.getCurrentUrl();
		System.out.println("The current page is: " + currentPage);
		
		driver.navigate().refresh();
		
		System.out.println(driver.getPageSource());
	}


	@After
	public void tearDown() throws Exception {
		driver.quit();
	}


	//important methods
	
/**
 * 
 * 1- driver.getTitle(); Return the title of the page
 * 2- driver.getCurrentUrl(); Return the URL of the current page
 * 3- driver.navigate().to(navigateTo); Navigate to a new set page
 * 4- driver.navigate().back(); Go back to the previous page
 * 5- driver.navigate().forward(); Go ahead to the next page from you got back
 * 6- driver.getPageSource() Get all source of the current page
 * 7- driver.navigate().refresh(); refresh the current page
 */
}
