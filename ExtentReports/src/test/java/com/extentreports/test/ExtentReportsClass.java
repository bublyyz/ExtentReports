package com.extentreports.test;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsClass {
	
	ExtentReports extent;
	 ExtentTest logger;
	 	 
	 @BeforeTest
	 public void startReport(){
		
		extent = new ExtentReports(System.getProperty("user.dir") +"\\reports\\er.html",true);
		extent.addSystemInfo("Host Name", "Software Testing Material");
        extent.addSystemInfo("Environment", "Automation Testing");
        extent.addSystemInfo("User Name", "Veena");
		
		 
	 }
	 
	// @Test
	 public void passTest(){
		 logger = extent.startTest("passTest");
		 Assert.assertTrue(true);
		 //To generate the log when the test case is passed
		 logger.log(LogStatus.PASS, "Test Case Passed is passTest");
	 }
	 
	 @Test
	 public void failTest(){
		 logger = extent.startTest("failTest");		 
		 Assert.assertTrue(false);
		 logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
	 }
	 
	 //@Test
	 public void skipTest(){
		 logger = extent.startTest("skipTest");
		 throw new SkipException("Skipping - This is not ready for testing ");
	 }
	 
	 @AfterMethod
	 public void getResult(ITestResult result) throws Exception{
		 if(result.getStatus() == ITestResult.FAILURE){
			 	
			 	Robot r=new Robot();
				Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
				Rectangle screenRect=new Rectangle(d);
				BufferedImage image= r.createScreenCapture(screenRect);
				String imagePath="D://abc.png";
				ImageIO.write(image,"png",new File(imagePath));	
				logger.addScreencast(imagePath);
				logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			 	logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			 	logger.log(LogStatus.FAIL,logger.addScreenCapture(imagePath));
				System.out.println(imagePath);
				
		 }
		 else if(result.getStatus() == ITestResult.SKIP){
			 logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		 }
		 extent.endTest(logger);
	 }
	 
	 @AfterTest
	 public void endReport(){
		 extent.flush();
	     extent.close();
	   }
}
