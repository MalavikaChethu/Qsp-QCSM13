package demo.actiTime.GenericUnits;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of methods to fetch the data from excel sheet
 * @author Balasubramanyam
 *
 */
public class ExcelUtils 
{
	/**
 	 * This method will return only the string data from excel sheet 
	 * @param filepath
	 * @param sheetName
	 * @param rowNo
	 * @param columnNo
	 * @return
	 */
	public String getStringData(String filepath, String sheetName, int rowNo,int columnNo)
	{
		try 
		{
			FileInputStream file = new FileInputStream(filepath);
			Workbook workBook = WorkbookFactory.create(file);
			return workBook.getSheet(sheetName).getRow(rowNo).getCell(columnNo).getStringCellValue();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method will return numeric data from excel sheet 
	 * @param filepath
	 * @param sheetName
	 * @param rowNo
	 * @param columnNo
	 * @return
	 */

	public double getNumericData(String filepath, String sheetName, int rowNo,int columnNo)
	{
		try 
		{
			FileInputStream file = new FileInputStream(filepath);
			Workbook workBook = WorkbookFactory.create(file);
			return workBook.getSheet(sheetName).getRow(rowNo).getCell(columnNo).getNumericCellValue();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return 0;
	}
	
/**
 *  This method will return all the data in the form of string
 * @param filepath
 * @param sheetName
 * @param rowNo
 * @param columnNo
 * @return
 */
	
	public String getData(String filepath, String sheetName, int rowNo,int columnNo)
	{
		try 
		{
			FileInputStream file = new FileInputStream(filepath);
			Workbook workBook = WorkbookFactory.create(file);
			return workBook.getSheet(sheetName).getRow(rowNo).getCell(columnNo).toString();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method will return boolean data from excel sheet 
	 * @param filepath
	 * @param sheetName
	 * @param rowNo
	 * @param columnNo
	 * @return
	 */
	
	public Boolean getBooleanData(String filepath, String sheetName, int rowNo,int columnNo)
	{
		try 
		{
			FileInputStream file = new FileInputStream(filepath);
			Workbook workBook = WorkbookFactory.create(file);
			return workBook.getSheet(sheetName).getRow(rowNo).getCell(columnNo).getBooleanCellValue();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
