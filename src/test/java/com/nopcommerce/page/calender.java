package com.nopcommerce.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class calender {
	public static WebDriver ldriver;
	public calender(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	String month="July 1986";
	String date="10";
	@FindBy(xpath="//span[@class='k-icon k-i-calendar']")
	WebElement calbtn;
	@FindBy(xpath="//*[@id=\"b95b3f2b-aa09-4cc5-b580-affd5ef64462\"]/div[1]/a[2]")
	WebElement expected;
	@FindBy(xpath="//*[@id=\"d4ba90e4-d930-4326-9705-b9718c84d559\"]/div[1]/a[1]")
	WebElement previous;
	
	
	
	
	public void selectDate() throws InterruptedException {
		calbtn.click();
		Thread.sleep(2000);
		while(true) {
			String text=expected.getText();
			if(text.equals(month)) {
			break;
		}else {
			previous.click();
			
		}
		
	}
}
}
