package com.nopcommerce.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.nopcommerce.utils.Readconfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	Readconfig readconfig=new Readconfig();
	public String baseURL=readconfig.getURL();
	public String username=readconfig.getuname();
	public String password=readconfig.getpword();
	public static WebDriver driver;
	public static Logger logger;
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports extent;
	@BeforeClass
	@Parameters("browser")
	public void setup() {
		
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		logger=Logger.getLogger("nopCommerce");
		PropertyConfigurator.configure("Log4j.properties");
		}
	@AfterClass
	public void teardown() {
		driver.quit();
	}
	public void screanshot(String tname) throws IOException {
		File target=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//TakesScreenshot ts=(TakesScreenshot) driver;
		//File source=ts.getScreenshotAs(OutputType.FILE);
		File source=new File("C:\\Users\\vishn\\eclipse-workspace\\nopcommerce2"+tname+".png");
		FileUtils.copyFile(target, source);
		System.out.println("Screan shot captured");
	}
	@BeforeTest
	public void setupExtent() {
		htmlreporter=new ExtentHtmlReporter("C://Users//vishn//eclipse-workspace//nopcommerce2//test-output/myreport.html");
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
