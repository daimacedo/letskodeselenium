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
import org.openqa.selenium.support.ui.Select;

public class DropDown {

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		baseUrl = "http://letskodeit.teachable.com/pages/practice";
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(baseUrl);
		WebElement element = driver.findElement(By.id("carselect"));
		Select sel = new Select(element);

		sel.selectByIndex(0);
		Thread.sleep(2000);

		sel.selectByValue("honda");
		Thread.sleep(2000);

		sel.selectByVisibleText("BMW");
		Thread.sleep(2000);

		List<WebElement> options = sel.getOptions();

		int size = options.size();

		for (int i = 0; i < size; i++) {
			System.out.println(options.get(i).getText());
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

}
