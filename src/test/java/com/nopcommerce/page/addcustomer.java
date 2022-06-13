package com.nopcommerce.page;



import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class addcustomer {
	public WebDriver ldriver;
	
	public addcustomer(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	//By lnkCustomer_Menu=By.xpath("//i[@class='nav-icon far fa-user']");
	@FindBy(xpath="//i[@class='nav-icon far fa-user']")
	WebElement lnkCustomer_Menu;
	//By link_cust=By.xpath("//p[contains(text(),' Customer roles')]/preceding::a/p[contains(text(),' Customers')]");	
	@FindBy(xpath="//p[contains(text(),' Customer roles')]/preceding::a/p[contains(text(),' Customers')]")
	WebElement link_cust;
	//By addbtn=By.xpath("//div//a[@class='btn btn-primary']"); 
	@FindBy(xpath="//div//a[@class='btn btn-primary']")
	WebElement addbtn;
	@FindBy(id="Email")
	WebElement textmail;
	@FindBy(id="Password")
	WebElement textpwd;
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFname;
	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLname;
	@FindBy(xpath="//input[@id='Gender_Male']")
	WebElement radioMale;
	@FindBy(xpath="//input[@id='Gender_Female']")
	WebElement radioFemale;
	@FindBy(xpath="//input[@id='Company']")
	WebElement Cname;
	
	@FindBy(xpath="//div[@class='k-multiselect-wrap k-floatwrap']//input[@class='k-input k-readonly']")
	WebElement newsletter;
	@FindBy(xpath="//following::div[@class='k-multiselect-wrap k-floatwrap'][2]")
	WebElement custRoll;
	@FindBy(xpath="//li[contains(text(),'Administrators')]")
	WebElement txtAdmin;
	@FindBy(xpath="//li[contains(text(),'Forum Moderators')]")
	WebElement txtForum;
	@FindBy(xpath="//li[contains(text(),'Guests')]")
	WebElement txtGust;
	@FindBy(xpath="//li[contains(text(),'Registered')]")
	WebElement txtRegister;
	
	@FindBy(xpath="//select[@id='VendorId']")
	WebElement drpVendor;
	@FindBy(xpath="//button[@name='save']")
	WebElement savebtn;
	public void addCustomer() {
		lnkCustomer_Menu.click();
		link_cust.click();
		addbtn.click();
		textmail.sendKeys("suj@gmail.com");
		textpwd.sendKeys("vishnu");
		txtFname.sendKeys("vishnu");
		txtLname.sendKeys("vardhan");
		Cname.sendKeys("XYZ");
		
	}
	public void setgender(String gender) {
		if(gender.equals("Male")) {
			radioMale.click();
		}else {
			if(gender.equals("Female")) {
				radioFemale.click();
				
			}
		}
	}
	public void dob() throws InterruptedException {
		calender cal=new calender(ldriver);
		cal.selectDate();
	}
	public void newsLetter(String value) {
		Actions action=new Actions(ldriver);
		action.click(newsletter).sendKeys(value).pause(1000).sendKeys(Keys.ENTER).build().perform();
	}
	public void customerRoll(String value) throws InterruptedException {
		WebElement clear=ldriver.findElement(By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/li/span[2]"));
		clear.click();
		
		Actions action= new Actions(ldriver);
		action.click(custRoll).sendKeys(value).pause(2000).sendKeys(Keys.ENTER).build().perform();
		
	}
	public void dropdown(String value) {
		Select select=new Select(drpVendor);
		select.selectByVisibleText(value);
		
	}
	public void savebtn() {
		savebtn.click();
	}
}
