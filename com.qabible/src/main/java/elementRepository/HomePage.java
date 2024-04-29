package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class HomePage 
{
	WebDriver driver;
	GeneralUtilities obj=new GeneralUtilities();
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Carol Thomas']")
	WebElement loggedInUser;
	
	public String verifyLoggedInUser()
	{
		return obj.getTextForAnElement(loggedInUser);
	}
}
