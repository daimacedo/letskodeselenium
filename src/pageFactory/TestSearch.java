package pageFactory;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSearch {
	
	private WebDriver driver;
	private String baseUrl;
	PageObjectSearchFactory searchPage;
	
	@Before
	public void setUp()
	{
		
		System.setProperty("webdriver.gecko.driver", "/home/daiane.macedo/Desktop/Daiane/seleniumDrivers/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com.br";
		searchPage = new PageObjectSearchFactory(driver);
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}
	
	@Test
	public void consultarVoo() throws InterruptedException
	{
		searchPage.clicarNoBotaoVoos();
		searchPage.preencherCidadePartida("New York");
		searchPage.preencherCidadeDestino("Chicago");
		searchPage.preencherDataPartida("10/10/2017");
		searchPage.preencherDataRetorno("25/10/2017");
		searchPage.clicarNoBotaoBusca();
		Thread.sleep(3000);
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
