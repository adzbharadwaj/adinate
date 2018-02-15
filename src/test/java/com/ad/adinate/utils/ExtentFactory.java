package com.ad.adinate.utils;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	
	public static ExtentReports getInstance() {
		ExtentReports report;
		report = new ExtentReports("./ExtentReports/ER1.html", false);
		return report;
	}
}
