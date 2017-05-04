package javaScriptExecution;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ScrollPageDownUpJS {

	private WebDriver driver;
	private JavascriptExecutor js;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();

		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void test() throws InterruptedException {
		js.executeScript("window.location= 'https://letskodeit.teachable.com/pages/practice'");
		Thread.sleep(6000);
		//o sleep esta tao grande aqui porque a pagina precisa carregar inteira para somente depois executar a rolagem
		//com 3 segundos a pagina ainda esta carregando e a rolagem nao funciona
		
		//Scroll Down
		js.executeScript("window.scrollBy(0, 1900)");
		Thread.sleep(3000);
		
		
		//Scroll Up
		js.executeScript("window.scrollBy(0,-1900)");
		Thread.sleep(3000);
		
		//Rolando a pagina até um elemento especifico da tela
		WebElement element = driver.findElement(By.id("mousehover"));
		js.executeScript("arguments[0].scrollIntoView(true)" , element);
		js.executeScript("window.scrollBy(0,-190)");
		
		
		
	}


	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}


}
