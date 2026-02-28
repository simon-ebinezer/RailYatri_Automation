package com.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.reusableMethods.Reusabels;

public class checkingTrainStatus extends BaseClass {
	
	private static Reusabels reuse;
	
	@FindBy(id = "trainField")
	private WebElement trainfield;
	
	@FindBy(xpath = "//span[text()=\"MGR CHENNAI CENTRAL - COIMBATORE Cheran SF Exp\"]")
	private WebElement suggesttrain;
	
	@FindBy(xpath = "//button[@class=\"trainEnquiryStyle_trackBtn__HMJFR\" and text()=\"Track Now\"]")
	private WebElement seacrhTrain;
	
	@FindBy(xpath = "//span[@style=\"padding-left:10px;color:#555\"]")
	private WebElement traveldate;
	
	@FindBy(xpath = "//div[text()=\"3 Days ago\"]")
	private WebElement daysago;
	
	@FindBy(xpath = "//button[@type=\"submit\" and text()=\"Check Status\"]")
	private WebElement checkstatus;
	
	@FindBy(xpath = "//td[text()=\"COIMBATORE JN~ (CBE)\"]")
	private WebElement coimbatorestatus;
	
	public checkingTrainStatus() {
		reuse = new Reusabels(10);
		PageFactory.initElements(driver, this);
	}
	
	public void enterTrainName(String trainName) {
		reuse.scrollAndClickByJS(trainfield);
		reuse.entertext(trainfield, trainName);
	}
	
	public void trainoptions() {
		reuse.Waitandclick(suggesttrain);
	}
	
	public void searchTrain() {
		reuse.Waitandclick(seacrhTrain);
	}
	
	public void SelectDate() {
		reuse.Waitandclick(traveldate);
		reuse.Waitandclick(daysago);
	}
	
	public void clickStatusButton() {
		reuse.Waitandclick(checkstatus);
	}
	
	public void selectcoimbatoreJN() {
		reuse.scrollAndView(coimbatorestatus);
		reuse.Waitandclick(coimbatorestatus);
	}

}
