package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectSearchFactory {
	
	WebDriver driver;
	
	@FindBy(id = "tab-flight-tab-hp" )
	WebElement tabVoos;
	
	
	@FindBy(id = "flight-origin-hp-flight")
	WebElement vooOrigem;
	
	@FindBy(id = "flight-destination-hp-flight")
	WebElement vooDestino;
	
	@FindBy(id = "flight-departing-hp-flight")
	WebElement dataIda;
	
	@FindBy(id = "flight-returning-hp-flight")
	WebElement dataVolta;
	
	@FindBy(xpath = "//*[@id=\"gcw-flights-form-hp-flight\"]/div[8]/label/button")
	WebElement btnBusca;
	
	
	public PageObjectSearchFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clicarNoBotaoVoos()
	{
		tabVoos.click();
	}
	
	public void clicarNoBotaoBusca()
	{
		btnBusca.click();
	}
	
	public void preencherCidadePartida(String cidadePartida)
	{
		vooOrigem.sendKeys(cidadePartida);
	}
	
	public void preencherCidadeDestino(String cidadeDestino)
	{
		vooDestino.sendKeys(cidadeDestino);
	}
	
	public void preencherDataPartida(String dataPartida)
	{
		dataIda.sendKeys(dataPartida);
	}
	
	public void preencherDataRetorno(String dataRetorno)
	{
		dataVolta.sendKeys(dataRetorno);
	}
}
