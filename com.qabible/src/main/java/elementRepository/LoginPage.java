package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);  //initElement() - for initializing elements which is declared by @FindBy
	}
	
	@FindBy(id="loginform-username")			//Declaration with page factory
	WebElement username;
	
	@FindBy(id="loginform-password")
	WebElement password;
	
	@FindBy(xpath="//button[@class='btn btn-default']")
	WebElement loginButton;
	
	public void enterUsername(String name)
	{
		username.sendKeys(name);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
}
