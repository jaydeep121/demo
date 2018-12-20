package com.thinkexam.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelLib {
	
	static String filepath="E:/Backup/thinkexam/src/main/java/com/thinkexam/testdata/Testdata.xls";
	static Workbook wb;
	public static String getExcelData(String sheet,int row,int cell) {
		String data="";
		try {
			wb=WorkbookFactory.create(new FileInputStream(new File(filepath)));
			data=wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();	
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	public static void writeExcelData() {
		
	}
}
