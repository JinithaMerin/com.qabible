package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead 
{
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;

	public static String readStringData(int row,int col,String sheet) throws IOException
	{
		f=new FileInputStream("//src//main//resources//WorkBook1.xlsx");
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheet);
		XSSFRow r=sh.getRow(row);
		XSSFCell c=r.getCell(col);
		return c.getStringCellValue();
	}
	public static String readIntegerData(int row,int col,String sheet) throws IOException
	{
		f=new FileInputStream("//src//main//resources//WorkBook1.xlsx");
		w=new XSSFWorkbook(f);
		sh=w.getSheet(sheet);
		XSSFRow r=sh.getRow(row);
		XSSFCell c=r.getCell(col);
		int val=(int) c.getNumericCellValue();
		return String.valueOf(val);
	}	
}