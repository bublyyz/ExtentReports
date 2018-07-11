package com.extentreports.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Sample {

	public static void main(String[] args) {
		
		com.aventstack.extentreports.ExtentReports erep= new ExtentReports();		
		ExtentHtmlReporter htmlrep= new ExtentHtmlReporter("./reports/Sample.html");		
		erep.attachReporter(htmlrep);
		
		ExtentTest test1=erep.createTest("ValidLogin");
		test1.pass("Valid login is pass");
		
		ExtentTest test2= erep.createTest("InvalidLogin");
		test2.fail("Invalid login is fail");
		
		erep.flush();
	}

}