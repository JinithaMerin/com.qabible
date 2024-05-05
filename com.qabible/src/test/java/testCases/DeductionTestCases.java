package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import elementRepository.DeductionPage;
import elementRepository.LoginPage;

public class DeductionTestCases extends BaseClass
{
	@Test
	public void verifyWorkerTypeDropdownInAddDeduction() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		DeductionPage dp=new DeductionPage(driver);
		dp.deductionTabClick();
		dp.addDeductionTabClick();
		String actual=dp.workersTypeDropDownSelect("Insurance");
		String expected="Insurance";
		Assert.assertEquals(actual,expected,"worker type invalid");
	}
	
	@Test
	public void verifyDatePicker() throws InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		DeductionPage dp=new DeductionPage(driver);
		dp.deductionTabClick();
		dp.addDeductionTabClick();
		dp.inputFieldClick();
		//dp.nextIconClick();
		String actual=dp.dateClick("5");
		String expected="05-05-2024";
		Assert.assertEquals(actual,expected,"Date is not selected");
	}
	
	@Test
	public void verifyWorkerNameDropdownInAddDeduction() throws InterruptedException 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		DeductionPage dp=new DeductionPage(driver);
		dp.deductionTabClick();
		dp.addDeductionTabClick();
		dp.dropDownButtonClick();
		dp.workerNameInputSearch("Dennis  Benny");
		Thread.sleep(1000);
		String actual=dp.selectWorkerName();
		String expected="Dennis  Benny";
		Assert.assertEquals(actual,expected,"worker name invalid");
	}
}
