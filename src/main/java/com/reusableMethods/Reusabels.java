package com.reusableMethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseClass;

public class Reusabels extends BaseClass{
	
	private static WebDriverWait wait;
	private static JavascriptExecutor js;
	private static Actions action;
	
	
	public Reusabels(int initofSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(initofSeconds));
		js = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
	}
	
	//This method is wait for the element and click action
	public void Waitandclick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	//This method is wait for the element visible
	public void waitforvisiblility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//This method is enter text in the respected filed
	public void entertext(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	//This method is to drag a element to the target
	public void dragAndDrop(WebElement source, WebElement target) {
		action.dragAndDrop(source, target);
	}
	
	//This method is click and hold the element
	public void clickAndHold(WebElement element) {
		action.clickAndHold(element);
	}
	
	//This method is to scroll down to the view and click the element
	public void scrollAndClickByJS(WebElement element) {
		try {
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
			Thread.sleep(500);
			element.click();
		}catch(Exception e) {
			throw new RuntimeException("unable to scroll and Click", e);
		}
	}
	
	//This method is to scroll down to the view
	public void scrollAndView(WebElement element) {
		try {
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		}catch(Exception e) {
			throw new RuntimeException("unable to scroll", e);
		}
	}
	
	//This method is to take screenshot the page
	public static String  takeScreenShot() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
	//This method is for select the dropdown options
	public void selectoptions(WebElement element) {
		Select select = new Select((WebElement) element);
	}
	
	
	
	

}
