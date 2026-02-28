package com.base;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	
	public static WebDriver driver;
	
	public void openBrowser(String browser, String url) {
		if(Objects.isNull(driver)) {
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}else {
				System.out.println("Please Pass the valid driver");
				throw new RuntimeException("Invalid Browser");
			}
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	public void closeBrowser() {
		if(Objects.nonNull(driver)) {
			driver.quit();
			driver = null;
		}
	}

}
