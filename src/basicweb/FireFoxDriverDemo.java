package basicweb;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

public class FireFoxDriverDemo {

	@Test
	public void teste() throws InterruptedException {
			
		// set property just for the 3.x webdriver
		// I need the gecko driver to it works
		System.setProperty("webdriver.gecko.driver", "/home/daiane.macedo/Desktop/Daiane/seleniumDrivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		String baseURL = "https://s3.amazonaws.com/saude-na-mao/sample.html";
		driver.get(baseURL);
		WebDriverWait waitComecar = new WebDriverWait(driver, 20);
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
		waitComecar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ac-pushButton")));
		driver.findElement(By.cssSelector("button.ac-pushButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='wc-list']/div[1]/div[1]/div[3]/div[1]/div[1]/button[text()='Ultrassonografia']")).click();
		
		
	
		

	}

}
