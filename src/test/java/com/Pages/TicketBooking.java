package com.Pages;

import java.util.List;

import org.apache.logging.log4j.message.ReusableSimpleMessage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.reusableMethods.Reusabels;

public class TicketBooking extends BaseClass {
	
	private Reusabels reuse;
	
	@FindBy(id = "TrainFromSourceField")
	private WebElement from;
	
	@FindBy(xpath = "//span[text()=\"CHENNAI BEACH\"]")
	private WebElement chennaibeach;
	
	@FindBy(id = "toSourceField")
	private WebElement to;
	
	@FindBy(xpath = "//span[text()=\"COIMBATORE JN\"]")
	private WebElement coimbatorejn;
	
	@FindBy(xpath = "//label[@class=\"verticalStyle_dateFieldLable__9JaUR\"]")
	private WebElement datepicker;
	
	@FindBy(xpath = "//button[@title=\"Next month\"]")
	private WebElement nextbutton;
	
	@FindBy(xpath = "//button[@role=\"gridcell\"]")
	private List<WebElement> Marchdates;
	
	@FindBy(xpath = "//button[text()='Search train']")
	private WebElement search;
	
	@FindBy(xpath = "//label[contains(.,'Night')]//input[@type='checkbox']")
	private WebElement checkbox;
	
	@FindBy(xpath = "//span[text()=\"12601\"]")
	private WebElement trainno;
	
	@FindBy(xpath = "//div[@class=\"style_booknowcontainer__C0iaw MuiBox-root css-0\"]//following::button[text()=\"Book Now\"]")
	private WebElement booknowbutton;
	
	
	
	public TicketBooking() {
		reuse = new Reusabels(10);
		PageFactory.initElements(driver, this);
	}
	
	public void enterFrom(String area) {
		reuse.Waitandclick(from);
		reuse.entertext(from, area);
	}
	
	public void selectArea() {
		reuse.Waitandclick(chennaibeach);
	}
	
	public void enterTo(String area) {
		reuse.Waitandclick(to);
		reuse.entertext(to, area);
	}
	
	public void selectDestination() {
		reuse.Waitandclick(coimbatorejn);
	}
	
	public void clickcalendar() {
		reuse.Waitandclick(datepicker);
		reuse.Waitandclick(nextbutton);
	}
	
	public void selectDate() {
		for(WebElement date : Marchdates) {
			if(date.getText().contains("18")) {
				reuse.Waitandclick(date);
				break;
			}
		}
	}
	
	public void enterSearch() {
		reuse.Waitandclick(search);
		reuse.takeScreenShot();
	}
	
	public void selectNightCheckbox() {
		reuse.scrollAndClickByJS(checkbox);
	}
	
	public void bookButton() {
		reuse.scrollAndClickByJS(booknowbutton);
	}

}
