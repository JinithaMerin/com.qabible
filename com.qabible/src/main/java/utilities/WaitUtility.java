package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility 
{
	
	public void WaitForThePresenceOfElement(String path,WebDriver driver)
	{
		WebDriverWait webdriverwaitobj = new WebDriverWait(driver,Duration.ofSeconds(10));
		webdriverwaitobj.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));

	}
	
	public void AlertToBePresent(String path,WebDriver driver)
	{
		WebDriverWait webdriverwaitobj = new WebDriverWait(driver,Duration.ofSeconds(10));
		webdriverwaitobj.until(ExpectedConditions.alertIsPresent());
	}
}
