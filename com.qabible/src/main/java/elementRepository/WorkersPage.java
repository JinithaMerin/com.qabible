package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;
import utilities.GeneralUtilities;
import utilities.GeneralUtilities;
public class WorkersPage 
{
	GeneralUtilities obj=new GeneralUtilities();
	public WorkersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	WebDriver driver;

	@FindBy(xpath = "//a[text()='Workers']")
	WebElement workersButton;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement searchButton;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	WebElement resetButton;

	@FindBy(xpath = "//a[text()='Create Worker']")
	WebElement createWorkerButton;

	@FindBy(id = "worker-title")
	WebElement titleDropDown;

	@FindBy(xpath = "//a[@title='Delete']")
	WebElement deleteIcon;

	@FindBy(id="worker-phone")
	WebElement phoneNum;
	
	@FindBy(xpath="//a[@title='Update']")
	WebElement updateIcon;
	
	@FindBy(id="worker-email")
	WebElement workerEmail;
	
	public void workersTabClick() {
		workersButton.click();
	}

	public void searchButtonClick() {
		searchButton.click();
	}

	public String getSearchButtonText() 
	{
		return obj.getTextForAnElement(searchButton);
	}

	public String getBGColorOfResetButton() 
	{
		return obj.getStylePropertyValues(createWorkerButton,"background-color");
	}

	public void createWorkerButtonClick() 
	{
		createWorkerButton.click();
	}

	public String titleDropDownSelect(String titleSelectValue) 
	{
		return obj.getSelectedValueFromDropdown(titleDropDown,titleSelectValue);
	}

	public String tooltipValueOfDeleteIcon() 
	{
		return obj.getAttributeValue(deleteIcon,"title");
	}
	
	public String enterPhoneNumber(String num)
	{
		return num;
	}
	
	public void updateIconClick()
	{
		updateIcon.click();
	}
	
	public String workerMailId()
	{
		return obj.getAttributeValue(workerEmail,"value");
	}
}
