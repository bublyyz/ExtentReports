package com.extentreports.test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DemoTest {
	
	@Test(priority=1)
	public void validLogin(){
		Reporter.log("Executing ValidLogin789",true);
	}

	@Test(priority=2)
	public void invalidLogin(){
		Reporter.log("Executing Invalid123Login",true);
		Assert.fail();		
	}
	
	@AfterMethod
	public void CloseApp(ITestResult result){
		String name=result.getName();
		int res=result.getStatus();
		Reporter.log(name+" is " +res,true);
	}
}
