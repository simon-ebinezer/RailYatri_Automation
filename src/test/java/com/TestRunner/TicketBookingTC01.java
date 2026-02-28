package com.TestRunner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.TicketBooking;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.entity.MediaEntity.MediaEntityBuilder;
import com.base.BaseClass;
import com.reusableMethods.Reusabels;

public class TicketBookingTC01 extends BaseClass {
	
	@BeforeTest
	public void startTest() {
		ExtentReport();
	}
	
	@Test
	public void ticketBooking() {
		
		test = extent.createTest("Train Ticket booking");
		TicketBooking book = new TicketBooking();
		book.enterFrom("Chennai");
		test.log(Status.PASS, "Enter the From Text is succesfull");
		
		book.selectArea();
		test.log(Status.PASS, "Selected the area by the dropdown");
		
		book.enterTo("coimbatore");
		test.log(Status.PASS, "Enter the To Text is succesfull");
		
		book.selectDestination();
		test.log(Status.PASS, "Selected the area by the dropdown");
		
		book.clickcalendar();
		test.log(Status.PASS, "Calendar popup is successfully displayed");
		
		book.selectDate();
		test.log(Status.PASS, "Date is selected");
		
		book.enterSearch();
		test.info(com.aventstack.extentreports.MediaEntityBuilder.
				createScreenCaptureFromBase64String(Reusabels.takeScreenShot(), "Screenshot is succesfull").build());
		test.log(Status.PASS, "Succesfully directed to the booking page");
		
		book.selectNightCheckbox();
		test.log(Status.PASS, "Succesfully clickec the checkbox");
		
		book.bookButton();
		test.log(Status.PASS, "booking button direction is successful");
		
		
	}
	
	
	
	

}
