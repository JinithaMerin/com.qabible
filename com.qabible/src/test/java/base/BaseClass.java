package base;

import org.testng.annotations.Test;
import utilities.CaptureScreenShotOnFailure;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass 
{
	public WebDriver driver;
	public static Properties prop;

	public static void testBasic() throws IOException {
		prop=new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//config.properties");
		prop.load(ip);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browser) throws IOException 
	{
		
		if (browser.equals("Chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if (browser.equals("Edge"))
		{			
			driver = new EdgeDriver();
		}
		testBasic();
		driver.get(prop.getProperty("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
		
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult iTestResult) throws IOException 
	{
		if (iTestResult.getStatus() == iTestResult.FAILURE) 
		{
			CaptureScreenShotOnFailure obj = new CaptureScreenShotOnFailure();
			obj.captureScreenShotOnTestFailure(driver, iTestResult.getName());
		}
		driver.close();
	}

}
