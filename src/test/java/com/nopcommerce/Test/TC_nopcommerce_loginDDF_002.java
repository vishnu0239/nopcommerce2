package com.nopcommerce.Test;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.page.loginpage;
import com.nopcommerce.utils.Excel_util;

import junit.framework.Assert;

public class TC_nopcommerce_loginDDF_002 extends baseclass{

	 @Test(dataProvider="user")
	public void login(String username,String password) throws InterruptedException {
		
		driver.get(baseURL);
		loginpage lp=new loginpage(driver);
		lp.setuname(username);
		lp.setpassword(password);
		lp.clkbtn();
		
		Assert.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
		logger.info("login success");
		Thread.sleep(3000);
		lp.logout();
	}
	
	@DataProvider(name="user")
	public String[][] logindata() throws IOException{
		String path="C:\\Users\\vishn\\eclipse-workspace\\nopcommerce2\\src\\test\\java\\com\\nopcommerce\\testData\\userdata.xls";
		int rowcnt=Excel_util.getrowcount(path, "Sheet1");
		int colcnt=Excel_util.getcellcount(path, "Sheet1", 1);
		String logindata[][]=new String[rowcnt][colcnt];
		for(int i=1;i<=rowcnt;i++) {
			for(int j=0;j<colcnt;j++) {
				logindata [i-1][j]=Excel_util.getceldata(path, "Sheet1", i, j);
				
			}
		}
		return logindata;
	}
}
