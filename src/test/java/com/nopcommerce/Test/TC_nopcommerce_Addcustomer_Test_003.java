package com.nopcommerce.Test;

import java.io.IOException;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.nopcommerce.page.addcustomer;
import com.nopcommerce.page.loginpage;

public class TC_nopcommerce_Addcustomer_Test_003 extends baseclass{
	@Test
	public void loginTest() throws IOException, InterruptedException {
	driver.get(baseURL);
	logger.info("URL opened");
	loginpage lp=new loginpage(driver);
	lp.setuname(username);
	lp.setpassword(password);
	lp.clkbtn();
	AssertJUnit.assertEquals(driver.getTitle(), "Dashboard / nopCommerce administration");
	logger.info("login success");
	screanshot("login");
	Thread.sleep(3000);
	addcustomer adcus=new addcustomer(driver);
	adcus.addCustomer();
	adcus.setgender("Male");
	logger.info("Gender male selected");
	adcus.newsLetter("Your store name");
	adcus.customerRoll("Guests");
	logger.info("customer roll selected");
	adcus.dropdown("Vendor 1");
	adcus.savebtn();
	logger.info("Validation done for customer");
	String validation=driver.findElement(By.xpath("//div[@class='validation-summary-errors']")).getText();


/*	if(validation.equals("The new customer has been added successfully.")) {
		Assert.assertTrue(true);
		logger.info("testcase passed");
	}else{
		logger.info("Testcase failed");
	}*/
}
}
