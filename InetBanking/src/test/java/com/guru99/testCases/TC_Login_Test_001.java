package com.guru99.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.guru99.pageObjects.Login_Page;
import com.guru99.testBase.TestBase;

public class TC_Login_Test_001 extends TestBase
{
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("Application has opened");
		Login_Page loginpage = new Login_Page(driver);
		loginpage.setUserName(username);
		logger.info("Username has entered");
		loginpage.setPassword(password);
		logger.info("Password has entered");
		loginpage.clickLogin();
		logger.info("Clicked on login");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage123"))
		{
			Assert.assertTrue(true);
			logger.info("Successfully loggedin");
		}
		else
		{
			captureScreen(driver,"loginTest");
			
			Assert.assertTrue(false);
			logger.info("Failed to login");
		}
		
		
	}
	

}
