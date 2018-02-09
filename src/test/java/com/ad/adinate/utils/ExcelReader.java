package com.ad.adinate.utils;

import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static final Logger log4 = LogManager.getLogger(ExcelReader.class.getName());
	static FileInputStream fis;
	static XSSFWorkbook wb;
	static XSSFSheet sh;
	static XSSFRow row;
	
	static {
		try {
			fis = new FileInputStream("./TestData/TestData.xlsx");
			wb = new XSSFWorkbook(fis);
			log4.info("Reading Excel Sheet...");
			sh = wb.getSheet("Sheet1");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	
	public static int getNumberOfRows(String tcname) {
		int count=0;
		for(int i=1;i<sh.getPhysicalNumberOfRows();i++) {
			if(sh.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(tcname) && sh.getRow(i).getCell(2).getStringCellValue().equalsIgnoreCase("Y")) {
				count++;
			}
		}
		log4.info("Number of rows found with Y for testcase: "+ tcname +" is :" + count);
		return count;
	}
	
	public static int getNumberofTestDataColumns(String tcname) {
		for(int i = 1; i<sh.getPhysicalNumberOfRows();i++) {
			int nrws=0;
			if(sh.getRow(i).getCell(1).getStringCellValue().equalsIgnoreCase(tcname)) {
				nrws =sh.getRow(i).getPhysicalNumberOfCells() -3;
				log4.info("Number of data for testcase: "+tcname + "in row " + i +" is " + nrws );
				return nrws;
			}
		}
		return 0;
	}
	
	public static String[][] twoDtestData(String tcname){
		String[][] td = new String[getNumberOfRows(tcname)][getNumberofTestDataColumns(tcname)];
		int nri =0;
		for(int i=1;i<sh.getPhysicalNumberOfRows();i++) {
			row = sh.getRow(i);
			String tcnameinsheet = row.getCell(1).getStringCellValue();
			String runstatusinsheet = row.getCell(2).getStringCellValue();
			if(tcnameinsheet.equalsIgnoreCase(tcname) && runstatusinsheet.equalsIgnoreCase("Y")) {
				int nci =0;
				for(int c=3;c<row.getPhysicalNumberOfCells();c++) {
					td[nri][nci++]=row.getCell(c).getStringCellValue();
				}
				nri++;
			}
		}
		return td;
		
	}
	
	
}
