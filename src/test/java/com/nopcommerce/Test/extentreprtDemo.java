package com.nopcommerce.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentreprtDemo {

	public WebDriver driver;
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	@BeforeTest
	public void setupExtent() {
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myreport.html");
		htmlreporter.config().setDocumentTitle("Automation report");
		htmlreporter.config().setReportName("Functional Report");
		htmlreporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Testernmae", "visnu");
		extent.setSystemInfo("Browser", "Chrome");
	}
	@AfterTest
	public void endReport() {
		extent.flush();
	}
}
