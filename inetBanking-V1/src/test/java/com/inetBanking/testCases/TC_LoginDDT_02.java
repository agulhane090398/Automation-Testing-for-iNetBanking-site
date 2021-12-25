package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_02 extends BaseClass1
{

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username entered");
		lp.setPassword(pwd);
		logger.info("Password entered");
		lp.ClickSubmit();
		
		
		if(isAlertPresent()==true)
		{
			logger.info("loginDDT Fail");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login Pass");
			lp.ClickLogout();
			logger.info("Clicking on logout button");

			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean isAlertPresent() throws IOException, InterruptedException
	{
		try {
			driver.switchTo().alert();
			captureScreen(driver,"loginDDt");
			return true;
		}
		catch (NoAlertPresentException e) {
			// TODO: handle exception		
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testDatafiles/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colnum=XLUtils.getColCount(path, "Sheet1",1);
		
		String loginData[][]=new String[rownum][colnum];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
}
