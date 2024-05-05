package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DeductionPage 
{
	public DeductionPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	WebDriver driver;
	GeneralUtilities obj=new GeneralUtilities();
	//Actions action=new Actions(driver);
	
	
	@FindBy(xpath="//select[@id='deduction-type']")
	WebElement workerType;
	
	@FindBy(xpath="//a[text()='Deduction']")
	WebElement deductionButton;
	
	@FindBy(xpath="//a[text()='Add Deduction']")
	WebElement addDeductionButton;
	
	@FindBy(id="//input[@id='deduction-effective_from']")
	WebElement datePicker;
	
	@FindBy(xpath="//input[@id='deduction-effective_from']")
	WebElement inputFieldOfDate;
	
	@FindBy(xpath="//th[@class='next']")
	WebElement nextIconInDatePicker;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	WebElement workerNameInput;
	
	@FindBy(xpath="//span[@class='select2-selection__rendered']")
	WebElement workerNameSelect;
	
	@FindBy(xpath="//span[@class='select2-selection__arrow']")
	WebElement dropDownButtonInWorkerNameInputField;
	
	public void deductionTabClick()
	{
		obj.buttonClick(deductionButton);
	}
	
	public void addDeductionTabClick()
	{
		obj.buttonClick(addDeductionButton);
	}
	
	public String workersTypeDropDownSelect(String titleSelectValue) 
	{
		return obj.getSelectedValueFromDropdown(workerType,titleSelectValue);
	}
	
	public void workerNameInputSearch(String name)
	{
		workerNameInput.sendKeys(name);
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	
	public void inputFieldClick()
	{
		inputFieldOfDate.click();
	}
	
	public void nextIconClick()
	{
		nextIconInDatePicker.click();
	}
	
	public void dropDownButtonClick()
	{
		dropDownButtonInWorkerNameInputField.click();
	}
	
	
	public String selectWorkerName()
	{
		String name=workerNameSelect.getAttribute("title");
		return name;
	}
	
	public String dateClick(String date) throws InterruptedException
	{
		WebElement dateSelect=driver.findElement(By.xpath("//td[text()='"+date+"']"));
		dateSelect.click();	
		Thread.sleep(1000);
		String dateValue=inputFieldOfDate.getAttribute("value");
		return dateValue;
	}
}
