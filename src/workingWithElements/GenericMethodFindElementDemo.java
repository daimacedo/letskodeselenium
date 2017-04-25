package workingWithElements;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericmethods.GenericMethods;


public class GenericMethodFindElementDemo {

	private WebDriver driver;
	//Não posso instanciar o objeto Generic aqui porque ele recebe o driver dessa classe, 
	//e o driver dessa classe ainda nao foi instanciado, entao vai dar pau
	//GenericMethods gm = new GenericMethods(driver);
	private GenericMethods gm;
	private String baseUrl = "https://letskodeit.teachable.com/p/practice";
	private String baseUrl2 = "http://only-testing-blog.blogspot.com.br/2013/09/testing.html";
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "/home/adtsys/selenium_drivers/geckodriver");
		driver = new FirefoxDriver();
		gm = new GenericMethods(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	public void testGetElement() {
		driver.get(baseUrl);
		//Elemento tipo WebElement entao o methodo que encapsula o find de WebElement deve ser do tipo WebElement tambem
		WebElement element = gm.getElement("name", "id");
		element.sendKeys("test");
	}
	
	@Test
	public void testeGetListOfElement(){
		driver.get(baseUrl2);
		//Elemento tipo list, entao o metodo que encapsula o find de list deve ser do tipo LIST tambem
		List<WebElement> list = gm.getListElements("//div[@id='post-body-7114928646577071695']//input[contains(@name,'vehicle') and contains(@type, 'checkbox')]", "xpath");
		int size = list.size();
		System.out.println(size);
		for(int i=0; i<size; i++)
		{
			//só para testar imprimir a quantidade de vezes do tamanho da lista
			System.out.println(list.get(i).getAttribute("type"));
		}
		
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(5000);
	}

	

}
