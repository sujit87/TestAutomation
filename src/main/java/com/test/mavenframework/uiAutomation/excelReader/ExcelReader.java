package com.test.mavenframework.uiAutomation.excelReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	public static final Logger log = Logger.getLogger(ExcelReader.class.getName());
	
	public String path;
	public FileInputStream fis;
	public Workbook book;
	public Sheet sheet;
	public Row row;
	public Cell cell;
	
	public ExcelReader(String path)
	{
		this.path=path;
		
			try {
				fis = new FileInputStream(path);
				book = WorkbookFactory.create(fis);
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	@SuppressWarnings({ "deprecation"})
	public String[][] getDataFromExcel(String sheetName)
	{
		String dataSets[][] = null;
		try {
			log.info("===========Excel reader Starts=========");
			Sheet sheet;
			sheet = book.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum()+1;
			System.out.println("========"+totalRow+"=============");
			Row row = sheet.getRow(0);
			int totalColumn = row.getLastCellNum();
			System.out.println("========"+totalColumn+"=============");
			dataSets = new String[totalRow-1][totalColumn];
			for(int i=1;i<totalRow;i++)
			{
				row = sheet.getRow(i);
				for(int j=0;j<totalColumn;j++)
				{
					Cell cell = row.getCell(j);
					
					if(cell.getCellType()==Cell.CELL_TYPE_STRING)
						dataSets[i-1][j]=cell.getStringCellValue();
					else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
						String cellText = String.valueOf(cell.getNumericCellValue());
						dataSets[i-1][j]=cellText;
						}
						else
						dataSets[i-1][j] = String.valueOf(cell.getBooleanCellValue());
				}
			}
			log.info("==========Excel Reading Finished================");
			return dataSets;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("==========Excel Reading Finished================");
		return dataSets;
	}
	
	
	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, String colName, int rowNum)
	{
		int colNum = 0;
		
		try {
			sheet = book.getSheet(sheetName);
			Row row = sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++)
			{
				if(row.getCell(i).getStringCellValue().equals(colName))
					{
					colNum = i;
					break;
					}
					
			}
			
			row = sheet.getRow(rowNum-1);
			Cell cell = row.getCell(colNum);
			if(cell.getCellType()==Cell.CELL_TYPE_STRING)
			{
				return cell.getStringCellValue();
			}
			else if(cell.getCellType()==Cell.CELL_TYPE_BLANK)
			{
				return "";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}