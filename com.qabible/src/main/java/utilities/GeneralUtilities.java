package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities 
{
	public String getTextForAnElement(WebElement element)
	{
		String text=element.getText();
		return text;
	}
	
	public String getStylePropertyValues(WebElement element,String propertyType)
	{
		String cssValue=element.getCssValue(propertyType);
		return cssValue;
	}
	
	public String getAttributeValue(WebElement element,String attributeType)
	{
		String value=element.getAttribute(attributeType);
		return value;
	}
	
	public String getSelectedValueFromDropdown(WebElement element,String valueToSelect)
	{
		Select obj=new Select(element);
		obj.selectByVisibleText(valueToSelect);
		WebElement selectedValue=obj.getFirstSelectedOption();
		String text=selectedValue.getText();
		return text;
	}
	
	public String getCellDataWithReferenceCellValue(List<WebElement> l,String cellValue,WebDriver driver)
	{
		String locator=null;
		for(int i=0;i<l.size();i++)
		{
			if(l.get(i).getText().equals(cellValue))
			{
				locator="//table[@class='table table-striped table-bordered']//tbody//tr["+(i+1)+"]//td[2]";
				break;
			}
		}
		WebElement column=driver.findElement(By.xpath(locator));
		return column.getText();
	}
	
	/*public boolean searchOptionUsingClientId()
	{
		
	}*/
}
