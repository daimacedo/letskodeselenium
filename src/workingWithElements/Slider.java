package workingWithElements;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class Slider {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		baseUrl = "https://www.airbnb.com.br/s/Gramado--RS/homes?refinement_paths%5B%5D=%2Fhomes&query=Gramado%20-%20RS&place_id=ChIJHzIEeEIyGZURpq7lgfAlHKc&allow_override%5B%5D=&s_tag=bvwRa1DG";
		// baseUrl = "https://jqueryui.com/slider/";
		System.setProperty("webdriver.gecko.driver", "/home/daiane.macedo/Desktop/Daiane/seleniumDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void navegarNoSlider() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='Preço']")).click();
		WebElement SpotSlider = driver.findElement(By.xpath("//button[@aria-label='Preço Máximo']"));
		String finalPrice = "";

		// Mesmo finalPrice recebendo 2032, nao sai do while =/
		while(!finalPrice.equals("R$2032")){
			Actions builder = new Actions(driver);
			Thread.sleep(2000);
			builder.moveToElement(SpotSlider).click().dragAndDropBy(SpotSlider, -20, 0).build().perform();
			finalPrice = driver.findElement(By.xpath("//div[@class='_ncwphzu']/span[2]")).getText();
		}
		Thread.sleep(3000);
		// WebElement finalPrice =
		// driver.findElement(By.xpath("//div[@class='_ncwphzu']/span[2]"));
		Assert.assertEquals(finalPrice, "R$2032");
		driver.findElement(By.xpath("//button/span[text()='Aplicar']")).click();

	}

	@Ignore
	@Test
	public void sliderJQuery() throws InterruptedException {
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		WebElement slider = driver.findElement(By.xpath("//div[@id='slider']/span"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(slider, 100, 0).perform();
	}

}
