package com.guru99.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_New_Customer_Page  
{
	public WebDriver ldriver;
	
	public Add_New_Customer_Page(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement btnNewCustomer;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement txtCName;
	
	@FindBy(name="rad1")
	@CacheLookup
	WebElement radioGender;
	
	@FindBy(id="dob")
	@CacheLookup
	WebElement optDOB;
	
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement txtCity;
	

	@FindBy(name="state")
	@CacheLookup
	WebElement txtState;
	

	@FindBy(name="pinno")
	@CacheLookup
	WebElement txtPin;

	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement txtMobile;

	@FindBy(name="emailid")
	@CacheLookup
	WebElement txtEmail;

	
	public void setCustName(String custName)
	{
		btnNewCustomer.sendKeys(custName);
	}
	public void setPin(String pin)
	{
		txtPin.sendKeys(pin);
	}
	public void setGender(String gender)
	{
		radioGender.click();
	}
	
	public void setDOB(String mm,String dd, String yy)
	{
		optDOB.sendKeys(mm);
		optDOB.sendKeys(dd);
		optDOB.sendKeys(yy);
	}
	
	public void setAddress(String address)
	{
		txtAddress.sendKeys(address);
	}
	
	public void setCity(String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void setState(String state)
	{
		txtState.sendKeys(state);
	}
	
	public void setMobile(String mobile)
	{
		txtMobile.sendKeys(mobile);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
}
