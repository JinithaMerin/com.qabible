package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.LoginPage;
import elementRepository.WorkersPage;

public class WorkersTestCases extends BaseClass
{
	
	@Test(groups = "critical",retryAnalyzer = retry.Retry.class)
	public void verifySearchButtonTextInWorkersTab() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		WorkersPage wp=new WorkersPage(driver);
		wp.workersTabClick();
		wp.searchButtonClick();
		String actual=wp.getSearchButtonText();
		String expected="Search";
		Assert.assertEquals(actual,expected,"Search Button Text is invalid");
	}

	@Test(groups = "medium")
	public void verifyBGColorOfResetButtonInWokersTab() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		WorkersPage wp=new WorkersPage(driver);
		wp.workersTabClick();
		String actualColor=wp.getBGColorOfResetButton();
		String expectedColor = "rgba(0, 0, 0, 0)";
		Assert.assertEquals(actualColor,expectedColor,"color is not as Expected");
	}
	

	@Test(groups = "critical")
	public void verifyTitleDropDownSelect() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		WorkersPage wp=new WorkersPage(driver);
		wp.workersTabClick();
		wp.createWorkerButtonClick();
		String actual=wp.titleDropDownSelect("Mr");
		String expected= "Mr";
		Assert.assertEquals(actual,expected,"color is not as Expected");
	}
	
	@Test
	public void verifyTooltipValueOfDeleteIcon() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		WorkersPage wp=new WorkersPage(driver);
		wp.workersTabClick();
		String actual=wp.tooltipValueOfDeleteIcon();
		String expected= "Delete";
		Assert.assertEquals(actual,expected,"Tooltip value is not same");
	}
	
	@Test
	public void verifyPhoneNumberOfTheWorker() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		WorkersPage wp=new WorkersPage(driver);
		wp.workersTabClick();
		wp.createWorkerButtonClick();
		String actual=wp.enterPhoneNumber("8086034124");
		String expected="8086034124";
		Assert.assertEquals(actual,expected,"invalid Phone Number");
	}
	
	@Test
	public void verifyTheMailIdOfAWorkerThroughUpdateIcon() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		WorkersPage wp=new WorkersPage(driver);
		wp.workersTabClick();
		wp.updateIconClick();
		String actual=wp.workerMailId();
		String expected="jyot#his@gmail.com";
		Assert.assertEquals(actual, expected,"Invalid Email id");
	}
}
