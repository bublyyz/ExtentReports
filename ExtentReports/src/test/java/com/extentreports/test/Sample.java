/*package com.extentreports.test;
//import ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Sample {

	public static void main(String[] args) {
		
		com.aventstack.extentreports.ExtentReports erep= new ExtentReports();		
		ExtentHtmlReporter htmlrep= new ExtentHtmlReporter("./reports/er.html");		
		erep.attachReporter(htmlrep);
		
		ExtentTest test1=erep.createTest("ValidLogin");
		test1.pass("Valid login is pass");
		
		ExtentTest test2= erep.createTest("InvalidLogin");
		test2.fail("Invalid login is fail");
		
		erep.flush();
	}

}*/
