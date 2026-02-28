package com.base;

import java.io.File;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utilities.PropertyFile;

public class BaseClass extends BrowserFactory {
	
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;
		
	@BeforeMethod
	public void initilaizeBrowser() {
		openBrowser(PropertyFile.getProperty("browser"), PropertyFile.getProperty("url"));
	}
	
	@AfterMethod
	public void quitBrowser() {
		// closeBrowser();
		extent.flush();
	}
	
	public void ExtentReport() {
		
		String reportPath = System.getProperty("user.dir")+File.separator+"ExtentReport"+"Report";
		
		spark = new ExtentSparkReporter(reportPath);
		spark.config().setDocumentTitle("Railyatri Testing");
		spark.config().setReportName("Testing Report");
		spark.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		extent.setSystemInfo("Device", "Lenovo X series");
		extent.setSystemInfo("platform", "Windows");
		extent.setSystemInfo("Tester", "Simon Ebinezer");
			
		
	}

}
