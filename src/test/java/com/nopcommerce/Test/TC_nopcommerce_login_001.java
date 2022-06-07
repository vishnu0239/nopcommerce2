package com.nopcommerce.Test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;



import com.nopcommerce.page.SearchProduct;
import com.nopcommerce.page.addProduct;
import com.nopcommerce.page.loginpage;

public class TC_nopcommerce_login_001 extends baseclass{

	
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
		SearchProduct sp=new SearchProduct(driver);
		sp.clikCatalog();
		sp.clickProduct();
		Thread.sleep(2000);
		sp.table();
		
		sp.product();
		Thread.sleep(2000);
		logger.info("product search done");
		//------------addProduct----------
		
		addProduct ap=new addProduct(driver);
		
		ap.addbtn();
		logger.info("addbtn clicked");
		
		//ap.addproduct();
	//	logger.info("Successfully product added");
		
		
	}
		
		
		
	
}
