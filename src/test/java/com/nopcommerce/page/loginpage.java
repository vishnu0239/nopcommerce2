package com.nopcommerce.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	 public WebDriver ldriver;
	 
	public  loginpage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="Email")
	@CacheLookup
	WebElement txtuname;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement txtpword;
	
	@FindBy(xpath="//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement loginbtn;
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	

	public void setuname(String username) {
		txtuname.clear();
		txtuname.sendKeys(username);
	}
	public void setpassword(String password) {
		txtpword.clear();
		txtpword.sendKeys(password);
	}
	public void clkbtn() {
		loginbtn.click();
	}
	public void logout() {
		logout.click();
	}
	
}
