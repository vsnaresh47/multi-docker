package com.guru99.testCases;



import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.guru99.pageObjects.Add_New_Customer_Page;
import com.guru99.pageObjects.Login_Page;
import com.guru99.testBase.TestBase;
import com.guru99.utilities.XLUtils;



public class TC_Add_Customer_003 extends TestBase
{
	@Test(dataProvider="AddCustomer")
	public void addCustomerDetails(String customerName,String gen,String date,String month,
			String year,String addr, String cit,String stat, String pn, String mbil,
			String pwd,String uname, String pass) throws InterruptedException,IOException
	{
		
		Login_Page lp=new Login_Page(driver);
		lp.setUserName(uname);
		logger.info("user name provided");
		lp.setPassword(pass);
		logger.info("password provided");
		lp.clickLogin();
		
		Thread.sleep(3000);

		Add_New_Customer_Page addCus=new Add_New_Customer_Page(driver);
		
		addCus.setCustName(customerName);
		addCus.setGender(gen);
		addCus.setDOB(date, month, year);
		Thread.sleep(3000);
		addCus.setAddress(addr);
		addCus.setCity(cit);
		addCus.setState(stat);
		addCus.setMobile(mbil);
		addCus.setPin(pn);
		
				
		
	}
	
	@DataProvider(name="AddCustomer")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/main/java/com/guru99/testData/AddCustomer.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}

	
	
}
