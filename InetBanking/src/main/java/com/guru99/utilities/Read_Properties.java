package com.guru99.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Read_Properties
{
	Properties propert;
	
	public Read_Properties()
	{
		File src=new File("./Configuration//config.properties");
		
		try
		{
			FileInputStream fis=new FileInputStream(src);
			propert=new Properties();
			propert.load(fis);			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
				
	}
	
	public String getBaseURL()
	{
		String url=propert.getProperty("baseURL");
		return url;
	}
	public String getUsername()
	{
		String user_name=propert.getProperty("username");
		return user_name;
	}
	public String getPassword()
	{
		String pwd=propert.getProperty("password");
		return pwd;
	}
	public String getChromepath()
	{
		String chrome=propert.getProperty("chromepath");
		return chrome;
	}
	

}
