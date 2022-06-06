package com.nopcommerce.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {

	public static WebDriver ldriver;
	public SearchProduct(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="//i[@class='nav-icon fas fa-book']")
	WebElement catlog;
	@FindBy(xpath="//a[normalize-space()='Products']")
	WebElement product;
	
	
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='row']//tbody/tr"))
	List<WebElement> rowcount;
	@FindAll(@FindBy(how=How.XPATH,using="//tbody/tr[1]/td"))
	List<WebElement> colcount;
	//------------------Product search-------------------
	@FindBy(xpath="//input[@id='SearchProductName']")
	WebElement productName;
	@FindBy(xpath="//button[@id='search-products']")
	WebElement productSearch;
	@FindAll(@FindBy(how=How.XPATH,using="//*[@id=\"products-grid\"]/tbody/tr"))
	List<WebElement> afterSearchProduct;
	
	
	public void clikCatalog() {
		catlog.click();
	}
	public void clickProduct() {
		product.click();
	}
	public void table() {
	
	System.out.println("row count is:"+rowcount.size());
	System.out.println("col count is :"+colcount.size());
	WebElement paging=ldriver.findElement(By.id("products-grid_paginate"));
	List<WebElement> pagingcount=paging.findElements(By.tagName("a"));
	System.out.println(pagingcount.size());
	if(pagingcount.size()>0) {
		System.out.println("paging lines available");
		for(int i=1;i<pagingcount.size()-1;i++) {
			WebElement pages=ldriver.findElement(By.xpath("//a[contains(text(),'"+i+"')]"));
			pages.click();
			for(int r=1;r<rowcount.size();r++) {
				String col1= ldriver.findElement(By.xpath("//*[@id=\"products-grid\"]/tbody/tr["+r+"]/td[2]")).getText();
				String col2= ldriver.findElement(By.xpath("//*[@id=\"products-grid\"]/tbody/tr["+r+"]/td[3]")).getText();
				String col3= ldriver.findElement(By.xpath("//*[@id=\"products-grid\"]/tbody/tr["+r+"]/td[4]")).getText();
				String col4= ldriver.findElement(By.xpath("//*[@id=\"products-grid\"]/tbody/tr["+r+"]/td[5]")).getText();
				String col5= ldriver.findElement(By.xpath("//*[@id=\"products-grid\"]/tbody/tr["+r+"]/td[6]")).getText();
				String col6= ldriver.findElement(By.xpath("//*[@id=\"products-grid\"]/tbody/tr["+r+"]/td[7]")).getText();
				System.out.println(col1+"           "+col2+"           "+col3+"           "+col4+"           "+col5+"           "+col6);
				
			}
		}
	}
	}
	public void product() {
		productName.sendKeys("htc");
		productSearch.click();
		System.out.println("ProductSearch clicked");
		System.out.println(afterSearchProduct.size());
	}
	

}
