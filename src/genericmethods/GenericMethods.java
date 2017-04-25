package genericmethods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {
	
	WebDriver driver;
	int size;
	
	public GenericMethods(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public WebElement getElement(String locator, String type)
	{
		
		type = type.toLowerCase();
		if (type.equals("id")) {
			System.out.println("Element found with id: " + locator);
			return this.driver.findElement(By.id(locator));
		}
		else if (type.equals("name")) {
			System.out.println("Element found with name: " + locator);
			return this.driver.findElement(By.name(locator));
		}
		else if (type.equals("xpath")) {
			System.out.println("Element found with xpath: " + locator);
			return this.driver.findElement(By.xpath(locator));
		}
		else if (type.equals("css")) {
			System.out.println("Element found with css: " + locator);
			return this.driver.findElement(By.cssSelector(locator));
		}
		else if (type.equals("classname")) {
			System.out.println("Element found with classname: " + locator);
			return this.driver.findElement(By.className(locator));
		}
		else if (type.equals("tagname")) {
			System.out.println("Element found with tagname: " + locator);
			return this.driver.findElement(By.tagName(locator));
		}
		else if (type.equals("linktext")) {
			System.out.println("Element found with link text: " + locator);
			return this.driver.findElement(By.linkText(locator));
		}
		else if (type.equals("partiallinktext")) {
			System.out.println("Element found with partial link text: " + locator);
			return this.driver.findElement(By.partialLinkText(locator));
		}
		else {
			System.out.println("Locator type not supported");
			return null;
		}
	}
	
	
	public List<WebElement> getListElements(String locator, String type)
	{
		type = type.toLowerCase();
		List<WebElement> elementlist = new ArrayList<WebElement>();
		
		if(type.equals("id"))
		{
			elementlist = this.driver.findElements(By.id(locator));
		
		}
		else if (type.equals("name"))
		{
			
			elementlist = this.driver.findElements(By.name(locator));

		}
		
		else if (type.equals("xpath"))
		{
			
			elementlist = this.driver.findElements(By.xpath(locator));
		
		}
		
		
		else
		{
			System.out.println("Element type is not supported");

		}
		
		if(elementlist.isEmpty())
		{
			System.out.println("Element not found with: " + type + ":" + locator);
	
		}
		else
		{
			System.out.println("Element found with: " + type + ":" + locator);
			this.size = elementlist.size();

		}
		return elementlist;
		
			
	}

	
	public boolean isElementPresent(String locator, String type)
	{
		if(size>0)
		{
			return true;
		}
		else
		{
			return false;
		}


	}

	public WebElement isElementAvailable(WebElement locator, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(locator));		
		return null;
	}

	
	public WebElement waitForElement(By locator, int timeout)
	{
		WebElement element = null;
		
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 3);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
		}catch(Exception e)
		{
			System.out.println("Element is not available on the web page");
		}
		
		return element;
	}
}
