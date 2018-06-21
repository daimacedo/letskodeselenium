package workingWithElements;

import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.basic.BasicTreeUI.TreeExpansionHandler;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

import java.awt.*; 

public class CheckBoxAndRadioButton {
	WebDriver driver;
	String baseUrl;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver","/home/daiane.macedo/workspace2/cucumber/resources/seleniumDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		baseUrl = "https://www.freepdfconvert.com/pt";
		
	}


	@Ignore
	@Test
	public void testUploadArquivo1() throws InterruptedException {
		
		
		driver.get(baseUrl);
		Thread.sleep(3000);
		WebElement rb1 = driver.findElement(By.id("clientUpload"));
		Thread.sleep(3000);
		rb1.sendKeys("//home//daiane.macedo//Desktop//bemvindo.txt");
		Thread.sleep(10000);
		
	}


	@Test
	public void testUploadArquivo2() throws InterruptedException, AWTException {
		
		
		driver.get(baseUrl);
		Thread.sleep(2000);
		//WebElement teste = driver.findElement(By.xpath("//preceding-sibling::input[@name='clientUpload']"));
		WebElement teste = driver.findElement(By.xpath("//input[@name='clientUpload']/parent::div"));
		System.out.println(teste);
		teste.click();
		Thread.sleep(2000);
		
		StringSelection ss = new StringSelection("//home//daiane.macedo//Desktop//bemvindo.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				
		Robot robot = new Robot();
		robot.delay(1000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);
	

		
	}


	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}
}
