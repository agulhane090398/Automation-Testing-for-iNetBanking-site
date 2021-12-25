package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "/html/body/form/table/tbody/tr[1]/td[2]/input")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(xpath = "/html/body/form/table/tbody/tr[2]/td[2]/input")
	@CacheLookup
	WebElement textPassword;
	
	@FindBy(xpath="/html/body/form/table/tbody/tr[3]/td[2]/input[1]")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//*[@href=\"Logout.php\"]")
	@CacheLookup
	WebElement btnLogout;
	
	
	
	public void setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		textPassword.sendKeys(pwd);
	}
	
	public void ClickSubmit()
	{
		btnLogin.click();
	}
	
	public void ClickLogout()
	{
		btnLogout.click();
	}

	public void clickSubmit() {
		// TODO Auto-generated method stub
		
	}
}
