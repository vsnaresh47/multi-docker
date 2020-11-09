package com.guru99.testBase;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.guru99.utilities.Read_Properties;

public class TestBase {
	
	Read_Properties read_prop=new Read_Properties();
	
	public String baseURL=read_prop.getBaseURL();
	public String username=read_prop.getUsername();
	public String password=read_prop.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String brow)
	{
		logger =Logger.getLogger("Guru99");
		PropertyConfigurator.configure("log4j.properties");
		
		if(brow.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", read_prop.getChromepath());
			driver=new ChromeDriver();
		}
		else if(brow.equals("friefox"))
		{
			System.setProperty("webdriver.chrome.driver", read_prop.getChromepath());
			driver=new FirefoxDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", read_prop.getChromepath());
			driver=new InternetExplorerDriver();
		}
		
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
	}
	
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}
