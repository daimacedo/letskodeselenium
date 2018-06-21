package workingWithElements;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;

public class AutoComplete {

	private WebDriver driver;
	private String baseUrl = "https://www.expedia.com.br/";
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "/home/daiane.macedo/Desktop/Daiane/seleniumDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		driver.get(baseUrl);
		WebElement textCity = driver.findElement(By.id("flight-origin"));
		textCity.sendKeys("Ribei");
		
		WebElement options = driver.findElement(By.xpath(".//*[@id='typeahead-list']/div/div/ul"));
		List<WebElement> list = options.findElements(By.tagName("li"));
	
		for(WebElement teste1: list)
		{
			System.out.println(teste1.getText());
		}
		
		for(WebElement teste: list)
		{
			System.out.println(teste.getText());
			if(teste.getText().contains("Ribeirão Preto, Brasil (RAO)"));
			{
				teste.click();
				System.out.println("clicou");
				break;
			}
			
		}
		
		
		
	}
	
	@After
	public void tearDown() throws Exception {
	}

	

}
