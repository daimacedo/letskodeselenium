package workingWithElements;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import atu.testrecorder.ATUTestRecorder;

public class AutoRecorderTeste {
	WebDriver driver;
	String baseUrl;
	// import jar ATUTestRecorder_2.1.jar
	ATUTestRecorder recorder;

	@Before
	public void setUp() throws Exception {
		//define data to append to video name
		 DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		 Date date = new Date(0);
		  //Created object of ATUTestRecorder
		  //Provide path to store videos and file name format.
		 // the last parameter is a boolean, false means i dont want audio recorder
		  recorder = new ATUTestRecorder("/home/adtsys/selenium_drivers/","TesteLogarExpedia-"+dateFormat.format(date),false);
		  //To start video recording.
		  recorder.start(); 
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl = "https://www.expedia.com.br/";
		
	}


	@Test
	public void test() throws InterruptedException {
		
		
		driver.get(baseUrl);
		Thread.sleep(5000);
		WebElement rb1 = driver.findElement(By.id("flight-type-one-way"));
		rb1.click();
			
		
	}



	@After
	public void tearDown() throws Exception {
		
		driver.quit();
		recorder.stop();
	}
}
