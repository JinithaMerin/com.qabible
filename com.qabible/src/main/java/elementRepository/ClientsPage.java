package elementRepository;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ClientsPage 
{
	public ClientsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	GeneralUtilities obj=new GeneralUtilities();
	
	@FindBy(xpath="//table[@class='table table-striped table-bordered']//tbody//tr[1]//td")
	WebElement tableRow1;
	
	@FindBy(xpath="//a[text()='Clients']")
	WebElement clientsButton;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement searchButton;
	
	@FindBy(id="clientsearch-id")
	WebElement clientId;
	
	@FindBy(id="clientsearch-client_name")
	WebElement clientName;

	public void clientsTabClick()
	{
		clientsButton.click();
	}
	
	public void searchButtonClick() throws InterruptedException
	{
		searchButton.click();
		Thread.sleep(3000);
	}
	
	public void enterClientIdToSearch(String id) 
	{
		clientId.sendKeys(id);
	}
	
	public void enterClientnameToSearch(String name)
	{
		clientName.sendKeys(name);
	}
	
	public String cellData(String value)
	{
		List<WebElement> l=driver.findElements(By.xpath("//table[@class='table table-striped table-bordered']//tbody//tr//td[1]"));
		return obj.getCellDataWithReferenceCellValue(l,value,driver);
	}
	
	public String cellDataWithoutUtility()
	{
		List<WebElement> l=driver.findElements(By.xpath("//table[@class='table table-striped table-bordered']//tbody//tr//td[1]"));
		String locator=null;
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).getText().equals("3"))
			{
				locator="//table[@class='table table-striped table-bordered']//tbody//tr["+(i+1)+"]//td[2]";
				break;
			}
		}
		WebElement column=driver.findElement(By.xpath(locator));
		return column.getText();
	}
	
	public boolean rowData(String id)
	{
		boolean bol=false;
		List<WebElement> l=driver.findElements(By.xpath("//table[@class='table table-striped table-bordered']//tbody//tr//td[1]"));
		String locator=null;
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).getText().equals(id))
			{
				bol=true;
				//locator="//table[@class='table table-striped table-bordered']//tbody//tr["+(i+1)+"]//td[2]";
			}
			else
			{
				bol=false;
			}
		}
		return bol;
	}
}
