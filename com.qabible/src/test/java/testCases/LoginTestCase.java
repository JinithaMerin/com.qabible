package testCases;

import org.testng.annotations.Test;

import base.BaseClass;
import constant.Constant;
import elementRepository.HomePage;
import elementRepository.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTestCase extends BaseClass 
{
	@Test(groups = "medium")
	public void verifyLoginWithValidUser() 
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername("carol");
		lp.enterPassword("1q2w3e4r");
		lp.clickLoginButton();
		HomePage hp=new HomePage(driver);
		String expected= "CAROL THOMAS";
		String actual=hp.verifyLoggedInUser();
		Assert.assertEquals(actual, expected,Constant.errorMsgForFailedLogin);
	}
}
