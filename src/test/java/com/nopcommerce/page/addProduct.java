package com.nopcommerce.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class addProduct {
	public static WebDriver ldriver;
	public addProduct(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement addbtn;
	@FindBy(xpath="//div[contains(text(),'Product info')]")
	WebElement productinfo;
	@FindBy(xpath="//input[@id='Name']")
	WebElement txtpname;
	@FindBy(xpath="//textarea[@id='ShortDescription']")
	WebElement txtdescription;
	@FindBy(xpath="//ul[@id='SelectedCategoryIds_taglist']")
	WebElement categories;
	@FindBy(xpath="//ul[@id='SelectedManufacturerIds_taglist']")
	WebElement manufacture;
	//---------------Checkbox----------------
	
	@FindBy(xpath="//div[contains(text(),'Enter tags ...')]")
	WebElement producttag;
	@FindBy(xpath="//input[@id='ManufacturerPartNumber']")
	WebElement partnum;
	//------------------dropdown-------
	
	@FindBy(xpath=("//select[@id='ProductTypeId']"))
	WebElement ptype;
	@FindBy(xpath="//select[@id='ProductTemplateId']")
	WebElement pid;
	
	@FindBy(xpath="//*[@id=\"product-info\"]/div[2]/div[14]/div[2]/div/div[1]/div/div")
	WebElement croll;
	@FindBy(xpath="//*[@id=\"product-info\"]/div[2]/div[15]/div[2]/div/div[1]/div")
	WebElement ltstores;
	//---------------------------price menu
	@FindBy(xpath="//div[@id='product-price']")
	WebElement pricemenu;
	@FindBy(xpath="Price")
	WebElement price;
	@FindBy(xpath="//div[@class='float-right']//button[1]']")
	WebElement save;
	
	public void addbtn() {
		addbtn.click();
	}
	public void addproduct() throws InterruptedException {
		try{//productinfo.click();
		txtpname.sendKeys("HP LAP");
		txtdescription.sendKeys("laptop");
		Actions action=new Actions(ldriver);
		action.click(categories).sendKeys("Computers").pause(2000).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		action.click(manufacture).sendKeys("HP").pause(2000).sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		action.click(producttag).sendKeys("HP").pause(1000).sendKeys(Keys.ENTER).build().perform();
		partnum.sendKeys("vishnu");
		dropdown("Simple");
		dropdown("Simple product");
	
		//-------------------dropdown-------
		action.click(croll).sendKeys("Guests").pause(1000).sendKeys(Keys.ENTER).build().perform();
		action.click(ltstores).sendKeys("Your store name").pause(1000).sendKeys(Keys.ENTER).build().perform();
		dropdown("Vendor 1");
		pricemenu.click();
		}catch(StaleElementReferenceException e) {
			System.out.println("Product inf not click");
		}
		System.out.println("Price menu clicked");
		dropdown("Electronics & Software");
		System.out.println("Electronics & Software is selected");
		save.click();
		Thread.sleep(3000);
		
	}
	public void dropdown(String value) {
		WebElement select=ldriver.findElement(By.xpath("//option[contains(text(),'"+value+"')]"));
		JavascriptExecutor js=(JavascriptExecutor) ldriver;
		js.executeScript("arguments[0].scrollIntoView();",select);
		select.click();
	}
	

}
