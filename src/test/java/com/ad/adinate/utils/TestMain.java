package com.ad.adinate.utils;

import java.util.Arrays;

public class TestMain {
	public static void main(String[] args) {
		//ExcelReader.getNumberOfRows("verifyRegistrationPage");
		//ExcelReader.getNumberofTestDataColumns("verifyRegistrationPage");
		String[][] ta =ExcelReader.twoDtestData("verifyRegistrationPage");
		for(String[]t:ta) {
			System.out.println(Arrays.toString(t));
		}
	}
}
