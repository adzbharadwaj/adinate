package com.ad.adinate.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaderRevision {
	static FileInputStream fis;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;

	static {
		try {
			fis = new FileInputStream("./TestData/TestData.xlsx");
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Sheet1");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int getRowCount(String testCaseName) {
		int count = 0;
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			String tcNameFromSheet = row.getCell(1).getStringCellValue();
			String tcRunStatus = row.getCell(2).getStringCellValue();
			if (testCaseName.equalsIgnoreCase(tcNameFromSheet) && tcRunStatus.equalsIgnoreCase("Y")) {
				count++;
			}
		}
		return count;
	}

	public static int getColumnCount(String testCaseName) {
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			row = sheet.getRow(i);
			String tcnameinSheet = row.getCell(1).getStringCellValue();
			if (tcnameinSheet.equalsIgnoreCase(testCaseName)) {
				return row.getPhysicalNumberOfCells() - 3;
			}
		}
		return 0;
	}

	public static String[][] getTestData(String testCaseName) {
		String[][] td = new String[ExcelReaderRevision.getRowCount(testCaseName)][ExcelReaderRevision
				.getColumnCount(testCaseName)];
		int ri = 0;
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {

			row = sheet.getRow(i);
			String tcnameinsheet = row.getCell(1).getStringCellValue();
			String runStatusinSheet = row.getCell(2).getStringCellValue();
			if (tcnameinsheet.equalsIgnoreCase(testCaseName) && runStatusinSheet.equalsIgnoreCase("Y")) {
				int ci = 0;
				for (int j = 3; j < row.getPhysicalNumberOfCells(); j++) {
					td[ri][ci++] = row.getCell(j).getStringCellValue();
				}
				ri++;
			}

		}

		return td;

	}

	public static void main(String[] args) {
		int a = ExcelReaderRevision.getRowCount("verifyRegistrationPage");
		System.out.println(a);

		int cc = ExcelReaderRevision.getColumnCount("verifyRegistrationPage");
		System.out.println(cc);

		String[][] data = ExcelReaderRevision.getTestData("verifyRegistrationPage");

		for (String[] s : data) {
			System.out.println(Arrays.toString(s));
		}
	}
}
