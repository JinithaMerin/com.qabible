package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.ClientsPage;
import elementRepository.LoginPage;

public class ClientsTestCases extends BaseClass
{
	@Test(enabled=false)
	public void verifyClientNameWithId() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		ClientsPage cp=new ClientsPage(driver);
		cp.clientsTabClick();
		String actual=cp.cellData("3");
		String expected="Sam";
		Assert.assertEquals(actual,expected,"user invalid");
	}
	
	@Test(enabled=false)
	public void verifyClientNameWithId_withoutUtility() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		ClientsPage cp=new ClientsPage(driver);
		cp.clientsTabClick();
		String actual=cp.cellDataWithoutUtility();
		String expected="Sam";
		Assert.assertEquals(actual,expected,"user invalid");
	}
	
	@Test(enabled=true)
	public void verifySearchOptionInClientPage() throws InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		ClientsPage cp=new ClientsPage(driver);
		cp.clientsTabClick();
		cp.enterClientIdToSearch("2");
		cp.searchButtonClick();
		boolean actual=cp.rowData("2");
		boolean expected=true;
		Assert.assertEquals(actual,expected,"pass");
	}
}
